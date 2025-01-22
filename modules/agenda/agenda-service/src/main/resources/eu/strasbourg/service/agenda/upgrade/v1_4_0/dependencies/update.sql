alter table agenda_EventPeriod
    add times VARCHAR(75) null AFTER endDate;

alter table agenda_EventPeriod
    add startTime VARCHAR(75) null AFTER times;

alter table agenda_EventPeriod
    add endTime VARCHAR(75) null AFTER startTime;

alter table agenda_EventPeriod
    add isRecurrent BOOLEAN default 0 null AFTER endTime;

alter table agenda_Event
    add isRecurrent BOOLEAN default 0 null AFTER lastEndDate;

alter table agenda_CacheJson
    change jsonEvent jsonEventLegacy longtext null;

alter table agenda_CacheJson
    add jsonEvent longtext null after eventId;

COMMIT_TRANSACTION;