import redis
import os
import time

print("🧠 [Purplle AI]: Initializing Computer Vision Pipeline...")

# 1. Connect to the Redis Message Broker
redis_host = os.environ.get('REDIS_HOST', 'localhost')
redis_port = int(os.environ.get('REDIS_PORT', 6379))

try:
    r = redis.Redis(host=redis_host, port=redis_port, decode_responses=True)
    r.ping()
    print("✅ [Purplle AI]: Successfully connected to the Redis Broker!")
except Exception as e:
    print(f"❌ [Purplle AI]: Failed to connect to Redis: {e}")

print("👁️ [Purplle AI]: Standby. Waiting for storefront images to process...")

# 2. Keep the container alive and listening
while True:
    # OpenCV processing logic will go here in the next phase!
    time.sleep(5)