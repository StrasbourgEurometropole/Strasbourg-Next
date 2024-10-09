create index IX_7F2824FC on notification_Notification (status, expirationDate);
create index IX_7C8F543F on notification_Notification (status, publicationDate);

create index IX_5870626F on notification_UserNotificationChannel (channelId);

create index IX_96152B6D on notification_UserNotificationStatus (publikUserId[$COLUMN_LENGTH:75$]);

create index IX_7E89BC93 on notification_UserNotificationType (typeId);