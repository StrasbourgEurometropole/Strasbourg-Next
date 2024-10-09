create index IX_706A57E5 on activity_Activity (groupId);
create unique index IX_8C2E09DB on activity_Activity (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_25D1B11E on activity_ActivityCourse (activityId);
create index IX_2C6B340A on activity_ActivityCourse (groupId);
create unique index IX_D6492A16 on activity_ActivityCourse (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B52A4A0C on activity_ActivityCoursePlace (activityCourseId);
create index IX_D4F8BB7 on activity_ActivityCoursePlace (groupId);
create index IX_68CF8C0C on activity_ActivityCoursePlace (placeSIGId[$COLUMN_LENGTH:75$]);
create unique index IX_A65045C9 on activity_ActivityCoursePlace (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_834D5851 on activity_ActivityCourseSchedule (activityCoursePlaceId);
create index IX_A131EEF3 on activity_ActivityCourseSchedule (groupId);
create unique index IX_BD4F070D on activity_ActivityCourseSchedule (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_79BFE14 on activity_ActivityOrganizer (groupId);
create unique index IX_C14CE0CC on activity_ActivityOrganizer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_873ADFD3 on activity_Association (groupId);
create unique index IX_7D5F5A2D on activity_Association (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8983ED7B on activity_Practice (associationId);
create index IX_97A07639 on activity_Practice (groupId);
create unique index IX_755CE507 on activity_Practice (uuid_[$COLUMN_LENGTH:75$], groupId);