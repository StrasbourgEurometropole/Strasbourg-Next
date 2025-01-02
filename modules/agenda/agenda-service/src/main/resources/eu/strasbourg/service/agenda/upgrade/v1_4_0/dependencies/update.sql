alter table agenda_EventPeriod
    add startTime VARCHAR(75) default '00:00' null AFTER endDate;

alter table agenda_EventPeriod
    add endTime VARCHAR(75) default '00:00' null AFTER startTime;

alter table agenda_EventPeriod
    add isRecurrent BOOLEAN default 0 null AFTER endTime;

COMMIT_TRANSACTION;