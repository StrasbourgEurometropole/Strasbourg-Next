create table activity_Activity (
	uuid_ VARCHAR(75) null,
	activityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description TEXT null,
	order_ INTEGER,
	videosIds VARCHAR(75) null,
	imageId LONG,
	imagesIds VARCHAR(75) null,
	filesIds VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table activity_ActivityCourse (
	uuid_ VARCHAR(75) null,
	activityCourseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name STRING null,
	presentation TEXT null,
	arrangements TEXT null,
	price TEXT null,
	activityId LONG,
	organizerId LONG,
	duration INTEGER,
	imageId LONG,
	imageIds VARCHAR(75) null,
	videosIds VARCHAR(75) null,
	documentsIds VARCHAR(75) null
);

create table activity_ActivityCoursePlace (
	uuid_ VARCHAR(75) null,
	activityCoursePlaceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	activityCourseId LONG,
	placeSIGId VARCHAR(75) null,
	placeName STRING null,
	placeStreetNumber VARCHAR(75) null,
	placeStreetName VARCHAR(75) null,
	placeZipCode VARCHAR(75) null,
	placeCityId LONG
);

create table activity_ActivityCourseSchedule (
	uuid_ VARCHAR(75) null,
	activityCourseScheduleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	activityCoursePlaceId LONG,
	startTime VARCHAR(75) null,
	endTime VARCHAR(75) null,
	monday BOOLEAN,
	tuesday BOOLEAN,
	wednesday BOOLEAN,
	thursday BOOLEAN,
	friday BOOLEAN,
	saturday BOOLEAN,
	sunday BOOLEAN,
	comments STRING null,
	periodsIds VARCHAR(75) null
);

create table activity_ActivityOrganizer (
	uuid_ VARCHAR(75) null,
	activityOrganizerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name STRING null,
	presentation TEXT null,
	address TEXT null,
	phone VARCHAR(75) null,
	mail VARCHAR(75) null,
	siteURL STRING null,
	imageId LONG
);

create table activity_Association (
	uuid_ VARCHAR(75) null,
	associationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	presentation TEXT null,
	phone VARCHAR(75) null,
	siteURL STRING null,
	mail VARCHAR(75) null,
	facebookURL STRING null,
	othersInformations TEXT null,
	order_ INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table activity_Practice (
	uuid_ VARCHAR(75) null,
	practiceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	associationId LONG
);