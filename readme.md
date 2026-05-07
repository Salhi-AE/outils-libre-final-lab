# 🛒 Pricing & Discount Engine Lab

## 📌 Project Overview
This project is a robust **Pricing Engine** developed in Java and verified using a hybrid testing approach (Unit & Integration). The core goal was to transform a "poorly designed" initial codebase into a maintainable, clean, and well-tested system following **SOLID** principles and modern DevOps workflows.

## 🛠️ Tech Stack
* **Language:** Java 21 & Python 3.13
* **Build System:** Gradle
* **Testing:** JUnit 5 (Unit Testing) & Subprocess-based Python scripts (Integration Testing)
* **Version Control:** Git

---

## 🚀 Key Features & Refactoring
During the lab, I performed several architectural improvements:
* **Separation of Concerns:** Moved discount logic into a dedicated `DiscountManager` class to keep the main engine clean and maintainable.
* **Edge Case Handling:** Implemented safety guards using `Math.max(0, ...)` to ensure the final price never drops below zero, even if discounts exceed the subtotal.
* **Input Flexibility:** Modified the application to accept command-line arguments, enabling seamless integration with external tools and scripts.
* **Clean Architecture:** Transitioned from loose variables to structured data handling using modern Java practices.

---

## 🧪 Testing Strategy

### 1. Unit Testing (JUnit 5)
I implemented a comprehensive suite of unit tests to verify individual logic components:
* **Customer Tiers:** Validating correct discount rates for REGULAR and VIP levels.
* **Empty Cart Handling:** Ensuring the engine returns 0.0 for empty item lists.
* **Precision Check:** Using a delta (e.g., 0.01) to account for floating-point arithmetic in financial calculations.

### 2. Integration Testing (Python Bridge)
A core requirement was the **Python Integration Script** (`test_integration.py`). This script treats the Java application as a "Black Box":
* It dynamically locates compiled `.class` files in both Gradle (`build/`) and IntelliJ (`out/`) directories.
* It executes the JVM, passes inputs as CLI arguments, and captures the standard output.
* It automates multiple test scenarios to ensure system-wide stability.

**Scenarios Verified:**
| Scenario | Price/Qty | Customer | Promo | Expected | Result |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Standard | 100 / 1 | REGULAR | NONE | 109.25 | ✅ Passed |
| VIP Loyalty | 400 / 1 | VIP | SAVE20 | 345.0 | ✅ Passed |
| Negative Guard | 10 / 1 | REGULAR | SAVE20 | 0.0 | ✅ Passed |

---

## 🏗️ How to Run

### Prerequisites
* JDK 21
* Python 3.x
* Gradle (included wrapper)

### Step 1: Compile and Build
```powershell
./gradlew build
```

### Step 2: Run Unit Tests
```./gradlew test
```
###Step 3: Run Python Integration Tests
```python test_integration.py
```
### 📈 Learning Outcomes
Polyglot Development: Successfully bridged Java and Python environments.

Defensive Programming: Handled "Edge Cases" like negative balances and null inputs.

Infrastructure Management: Overcame Gradle configuration challenges and environment mismatches.

CI/CD Fundamentals: Maintained a clean Git history with logical commits for every refactoring step.![licensed-image.jpg](../../AppData/Local/Temp/licensed-image.jpg)