alter table agenda_EventPeriod
    add startTime VARCHAR(75) null AFTER endDate;

alter table agenda_EventPeriod
    add endTime VARCHAR(75) null AFTER startTime;

COMMIT_TRANSACTION;