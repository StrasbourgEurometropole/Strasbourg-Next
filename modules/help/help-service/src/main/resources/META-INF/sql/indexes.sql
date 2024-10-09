create index IX_1E063953 on help_HelpProposal (groupId);
create index IX_94D0E999 on help_HelpProposal (publikId[$COLUMN_LENGTH:75$], helpProposalId);
create unique index IX_F56450AD on help_HelpProposal (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_927AB78 on help_HelpRequest (helpProposalId);
create index IX_F58F2B96 on help_HelpRequest (publikId[$COLUMN_LENGTH:75$]);
create unique index IX_F1BACD2C on help_HelpRequest (uuid_[$COLUMN_LENGTH:75$], groupId);