#!/bin/bash

# Database credentials
DB_HOST=${DB_HOST:-db}
DB_USER=${DB_USERNAME:-lportal}
DB_PASS=${DB_PASSWORD:-lportal}
DB_NAME=${DB_DB:-lportal}

# Function to check if the table exists
check_table_exists() {
  local result=$(mysql -h $DB_HOST -u $DB_USER -p$DB_PASS $DB_NAME -e "SELECT 1 FROM User_ LIMIT 1;" 2>/dev/null)
  if [ -z "$result" ]; then
    return 1  # Table does not exist
  else
    return 0  # Table exists
  fi
}

# Function to run the copy_db.sh script
run_copy_db_script() {
  echo "Database not initialized. Copying dump to db..."

  # Dump the source database
  echo "Dumping source database..."
  mysqldump --no-tablespaces -h "s17st" -u "lportal" -p"$SOURCE_DB_PASSWORD" "05_08_liferay_74" > /tmp/db_backup.sql

  # Import the dump into the target database
  echo "Importing database to target..."
  mysql -h "$DB_HOST" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" < /tmp/db_backup.sql

  # Clean up the temporary dump file
  rm /tmp/db_backup.sql

  echo "Database copy completed successfully."

}

check_db() {
  if check_table_exists; then
      echo "Database initalized. No action needed."
    else
      run_copy_db_script
    fi
}

echo "Waiting for MySQL and Elasticsearch to be up..."

/wait-for-it.sh -t 0 db:3306

/wait-for-it.sh -t 0 elasticsearch:9200

check_db


