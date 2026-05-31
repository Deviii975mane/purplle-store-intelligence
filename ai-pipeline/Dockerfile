# Use a lightweight Python image for fast building
FROM python:3.10-slim

WORKDIR /app

# Install the Python libraries
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Copy our AI script
COPY . .

# Run the script (-u forces Python to print logs immediately to the terminal)
CMD ["python", "-u", "main.py"]