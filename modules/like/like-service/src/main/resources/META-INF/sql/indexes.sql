create index IX_41985B6B on like_Like (entityId, typeId, isDislike);
create index IX_4B68609B on like_Like (publikUserId[$COLUMN_LENGTH:75$], isDislike);
create index IX_EFE52208 on like_Like (publikUserId[$COLUMN_LENGTH:75$], typeId, entityId, isDislike, title[$COLUMN_LENGTH:255$]);
create index IX_6F8654FD on like_Like (publikUserId[$COLUMN_LENGTH:75$], typeId, entityId, title[$COLUMN_LENGTH:255$]);