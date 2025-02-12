ALTER TABLE project_BudgetPhase
    ADD depositUrl VARCHAR(200) null AFTER endDate;
ALTER TABLE project_BudgetPhase
    ADD voteUrl VARCHAR(200) null AFTER endVoteDate;

ALTER TABLE project_BudgetParticipatif
    ADD positivePaperVotes LONG not null default 0 AFTER crushComment;
ALTER TABLE project_BudgetParticipatif
    ADD negativePaperVotes LONG not null default 0 AFTER positivePaperVotes;

ALTER TABLE project_BudgetSupport
    ADD isNegatif BOOLEAN not null default false AFTER citoyenCity;
ALTER TABLE project_BudgetPhase
    ADD maxVoteBudget LONG not null default 3 AFTER numberOfVote;
ALTER TABLE project_BudgetPhase
    ADD thresholdNegative LONG not null default 5 AFTER maxVoteBudget;
ALTER TABLE project_BudgetPhase
    ADD numberOfNegativeVote LONG not null default 1 AFTER thresholdNegative;
create index IX_A7452AA4 on project_BudgetSupport (budgetParticipatifId, isNegatif);
create index IX_9C788CF9 on project_BudgetSupport (budgetParticipatifId, publikUserId[$COLUMN_LENGTH:75$], isNegatif);
create index IX_EA62D111 on project_BudgetSupport (publikUserId[$COLUMN_LENGTH:75$], isNegatif);
IX_155DAB95
IX_528650AD

UPDATE project_BudgetSupport
    SET isNegatif = false;

COMMIT_TRANSACTION;