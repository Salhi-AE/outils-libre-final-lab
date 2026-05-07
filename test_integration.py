import subprocess
import os

def run_java_direct(price, qty, customer_type, promo):
    cp = "app/build/classes/java/main;app/build/resources/main;out/production/app.main;app/out/production/app.main"

    cmd = [
        "java", "-cp", cp,
        "com.lab.pricing.App",
        str(price), str(qty), customer_type, promo
    ]

    try:
        result = subprocess.run(cmd, capture_output=True, text=True, shell=True)
        if result.stderr and not result.stdout:
            return f"Java Error: {result.stderr}"
        return result.stdout.strip()
    except Exception as e:
        return f"Python Error: {str(e)}"

print("---  Starting System Integration Test ---")
output = run_java_direct(100, 1, "VIP", "SAVE10")

print(f"Engine Output: {output}")

if "80.5" in output:
    print("✅ SUCCESS: The Pricing Engine is working perfectly with Python!")
else:
    print("❌ FAILED: Check if the Java classes are compiled (Click Run in App.java first).")