import os
import time
import json
import redis
import random

# 1. Grab environment variables passed down from Docker
CAMERA_ID = os.getenv("CAMERA_ID", "CAM_UNKNOWN")

# 2. Connect to the Redis broker on the Docker network
r = redis.Redis(host='redis', port=6379, decode_responses=True)

print(f"🧠 [Purplle AI]: Initializing Context Engine for {CAMERA_ID}...")
print(f"✅ [Purplle AI]: Deep Memory Core connected to Redis!")
print(f"👁️ [Purplle AI]: Analyzing video feed for {CAMERA_ID} at 2 FPS...")

def analyze_frame_and_detect():
    alert_payload = {
        "entity_id": f"TRACK_ID_{random.randint(1000, 9999)}",
        "employee_probability": 0.02,
        "customer_probability": 0.98,
        "browsing_confidence": 0.15,
        "suspicion_confidence": 0.92,
        "checkout_verification_status": "BYPASSED",
        "product_tracking_status": "CONCEALED",
        "current_zone": CAMERA_ID,  # <--- INJECTS THE SPECIFIC CAMERA LOCATION
        "risk_level": "CRITICAL"
    }
    
    print(f"\n🚨 [{CAMERA_ID}]: CRITICAL ANOMALY DETECTED!")
    print(f"   -> Zone: {alert_payload['current_zone']} | Suspicion: {alert_payload['suspicion_confidence']}")
    print(f"📤 [{CAMERA_ID}]: Pushing JSON to Redis 'security_alerts' channel...")
    
    r.publish('security_alerts', json.dumps(alert_payload))

try:
    frame_count = 0
    while True:
        time.sleep(2) 
        frame_count += 1
        
        # Trigger an alert every 10 seconds for testing
        if frame_count % 5 == 0:
            analyze_frame_and_detect()
        else:
            print(f"🔄 [{CAMERA_ID}]: Frame clear. Tracking entities...")

except KeyboardInterrupt:
    print(f"Shutting down {CAMERA_ID} Pipeline...")