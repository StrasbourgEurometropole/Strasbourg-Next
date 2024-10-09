create index IX_EE1FE1E5 on comment_Comment (groupId);
create index IX_FC990D85 on comment_Comment (publikId[$COLUMN_LENGTH:75$]);
create index IX_64D05FD8 on comment_Comment (status, assetEntryId, level);
create index IX_57975095 on comment_Comment (status, parentCommentId);
create unique index IX_8B093FDB on comment_Comment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B31CB9C9 on comment_Signalement (commentId);
create index IX_FFD15D29 on comment_Signalement (groupId);
create index IX_2116FAC1 on comment_Signalement (publikId[$COLUMN_LENGTH:75$]);
create unique index IX_28975017 on comment_Signalement (uuid_[$COLUMN_LENGTH:75$], groupId);