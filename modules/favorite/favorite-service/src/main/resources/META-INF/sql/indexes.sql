create index IX_B9B7B5D on favorite_Favorite (entityGroupId, entityId, typeId);
create index IX_3C55C3C0 on favorite_Favorite (entityId, typeId);
create index IX_3771575D on favorite_Favorite (publikUserId[$COLUMN_LENGTH:75$], typeId, entityId, title[$COLUMN_LENGTH:255$]);
create index IX_96B3F2FE on favorite_Favorite (typeId, entityId, publikUserId[$COLUMN_LENGTH:75$], content[$COLUMN_LENGTH:75$]);