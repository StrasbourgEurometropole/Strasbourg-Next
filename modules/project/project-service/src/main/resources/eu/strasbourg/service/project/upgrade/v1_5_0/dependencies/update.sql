ALTER TABLE project_BudgetPhase
    ADD depositUrl VARCHAR(200) null AFTER endDate;
ALTER TABLE project_BudgetPhase
    ADD voteUrl VARCHAR(200) null AFTER endVoteDate;

ALTER TABLE project_BudgetParticipatif
    ADD positivePaperVotes LONG not null default 0 AFTER crushComment;
ALTER TABLE project_BudgetParticipatif
    ADD negativePaperVotes LONG not null default 0 AFTER positivePaperVotes;

COMMIT_TRANSACTION;