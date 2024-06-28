alter table council_Deliberation
    add amendement VARCHAR(3) null AFTER statusDate;

COMMIT_TRANSACTION;