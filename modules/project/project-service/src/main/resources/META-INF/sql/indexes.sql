create index IX_7C6D150C on project_BudgetParticipatif (budgetPhaseId);
create index IX_DD68BE86 on project_BudgetParticipatif (groupId, status, isCrush);
create unique index IX_F9CAE37F on project_BudgetParticipatif (groupId, uuid_[$COLUMN_LENGTH:75$]);
create index IX_57EEF28E on project_BudgetParticipatif (parentId);
create index IX_D87960D5 on project_BudgetParticipatif (publikId[$COLUMN_LENGTH:75$]);
create index IX_FFBF985F on project_BudgetParticipatif (uuid_[$COLUMN_LENGTH:75$]);

create index IX_10A3FF78 on project_BudgetPhase (groupId, isActive);
create unique index IX_149CF22C on project_BudgetPhase (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_528650AD on project_BudgetSupport (budgetParticipatifId, publikUserId[$COLUMN_LENGTH:75$]);
create index IX_193E1720 on project_BudgetSupport (groupId);
create index IX_155DAB95 on project_BudgetSupport (publikUserId[$COLUMN_LENGTH:75$]);
create unique index IX_D15AC240 on project_BudgetSupport (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A66E4238 on project_Initiative (groupId, status);
create index IX_8561E7B8 on project_Initiative (publikId[$COLUMN_LENGTH:75$]);
create unique index IX_F62467CE on project_Initiative (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_25334934 on project_InitiativeHelp (initiativeId);
create index IX_61D1667F on project_InitiativeHelp (publikUserId[$COLUMN_LENGTH:75$], initiativeId);
create unique index IX_11875BEF on project_InitiativeHelp (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_578B702F on project_Participation (groupId, status);
create unique index IX_883E1EF7 on project_Participation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7FA69446 on project_Petition (groupId, status);
create index IX_EFA96A on project_Petition (publikId[$COLUMN_LENGTH:75$]);
create unique index IX_2EB29C00 on project_Petition (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_98BB8F56 on project_PlacitPlace (budgetParticipatifId);
create index IX_EEC80B2C on project_PlacitPlace (groupId);
create index IX_BFA6C339 on project_PlacitPlace (initiativeId);
create index IX_8FD2F0EE on project_PlacitPlace (participationId);
create index IX_1C0D6D6B on project_PlacitPlace (petitionId);
create index IX_AE47DC77 on project_PlacitPlace (placeSIGId[$COLUMN_LENGTH:75$]);
create index IX_9B962C6 on project_PlacitPlace (projectId);
create index IX_E9CCEA9E on project_PlacitPlace (saisineObservatoireId);
create unique index IX_DD0468B4 on project_PlacitPlace (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_80F5CFD7 on project_Project (groupId, status);
create unique index IX_DB52A4F on project_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FC72391B on project_ProjectFollowed (projectId);
create index IX_2A9E13B0 on project_ProjectFollowed (publikUserId[$COLUMN_LENGTH:75$], projectId);

create index IX_C5DB5312 on project_ProjectTimeline (budgetParticipatifId);
create index IX_6F4E9C8A on project_ProjectTimeline (projectId);

create index IX_E29A83FF on project_SaisineObservatoire (groupId, status);
create index IX_E32F07D1 on project_SaisineObservatoire (publikId[$COLUMN_LENGTH:75$]);

create index IX_86C956F3 on project_Signataire (groupId);
create index IX_2FAA258F on project_Signataire (petitionId, publikUserId[$COLUMN_LENGTH:75$]);
create index IX_E8FC746E on project_Signataire (petitionId, signataireName[$COLUMN_LENGTH:75$]);
create index IX_501057A2 on project_Signataire (publikUserId[$COLUMN_LENGTH:75$]);
create unique index IX_2A129F0D on project_Signataire (uuid_[$COLUMN_LENGTH:75$], groupId);