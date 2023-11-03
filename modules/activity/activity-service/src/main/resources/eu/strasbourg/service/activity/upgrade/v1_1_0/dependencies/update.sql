ALTER TABLE activity_ActivityCourse ADD COLUMN duration VARCHAR(75) AFTER organizerId;
COMMIT_TRANSACTION;