echo "Waiting for container liferay to start successfully with a timeout of 10 minute..."

# Use timeout to limit the waiting time to 1 minute
timeout 10m docker compose logs app -f 2>&1 | while read -r line; do
  echo "$line"
  if [[ "$line" == *"STARTED strasbourg-theme"* ]]; then
    echo "Container liferay has started successfully!"
    exit 0
  fi
done

# If the timeout is reached, print a message and exit with status 1
if [ $? -ne 0 ]; then
  echo "Timeout reached. Container liferay did not start successfully within 1 minute."
  exit 1
fi