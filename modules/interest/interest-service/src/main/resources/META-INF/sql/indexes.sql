create index IX_D3CE2D85 on interest_Interest (groupId);
create unique index IX_6A7CA03B on interest_Interest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_947818BB on interest_UserInterest (publikUserId[$COLUMN_LENGTH:75$]);