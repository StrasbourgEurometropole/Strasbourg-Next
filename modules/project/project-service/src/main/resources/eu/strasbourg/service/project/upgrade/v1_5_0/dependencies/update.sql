ALTER TABLE project_BudgetPhase
    ADD depositUrl VARCHAR(200) null AFTER endDate;
ALTER TABLE project_BudgetPhase
    ADD voteUrl VARCHAR(200) null AFTER endVoteDate;

COMMIT_TRANSACTION;