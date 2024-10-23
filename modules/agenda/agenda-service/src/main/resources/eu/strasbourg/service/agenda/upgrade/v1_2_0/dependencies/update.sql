alter table agenda_Campaign
    add provider VARCHAR(20) null AFTER endDate;

COMMIT_TRANSACTION;