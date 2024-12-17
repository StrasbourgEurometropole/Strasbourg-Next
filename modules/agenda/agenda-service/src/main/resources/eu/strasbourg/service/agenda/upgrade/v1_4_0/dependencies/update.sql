alter table agenda_EventPeriod
    add startTime VARCHAR(75) null AFTER endDate;

alter table agenda_EventPeriod
    add endTime VARCHAR(75) null AFTER startTime;

alter table agenda_EventPeriod
    add isRecurrent BOOLEAN null AFTER endTime;

COMMIT_TRANSACTION;