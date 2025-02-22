create table place_CacheJson (
	uuid_ VARCHAR(75) null,
	sigId VARCHAR(75) not null primary key,
	jsonLieu TEXT null,
	jsonHoraire TEXT null,
	createPlace DATE null,
	modifiedPlace DATE null,
	isActive BOOLEAN
);

create table place_CsmapCacheJson (
	uuid_ VARCHAR(75) null,
	sigId VARCHAR(75) not null primary key,
	jsonLieu TEXT null,
	jsonHoraire TEXT null,
	createPlace DATE null,
	modifiedPlace DATE null,
	isActive BOOLEAN
);

create table place_GoogleMyBusinessHistoric (
	uuid_ VARCHAR(75) null,
	googleMyBusinessHistoricId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	result INTEGER,
	operations TEXT null,
	errorDescription TEXT null,
	errorStackTrace TEXT null,
	startDate DATE null,
	finishDate DATE null
);

create table place_Historic (
	uuid_ VARCHAR(75) null,
	sigId VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	suppressionDate DATE null
);

create table place_Period (
	uuid_ VARCHAR(75) null,
	periodId LONG not null primary key,
	name STRING null,
	defaultPeriod BOOLEAN,
	startDate DATE null,
	endDate DATE null,
	alwaysOpen BOOLEAN,
	RTGreenThreshold LONG,
	RTOrangeThreshold LONG,
	RTRedThreshold LONG,
	RTMaxThreshold LONG,
	placeId LONG
);

create table place_Place (
	uuid_ VARCHAR(75) null,
	placeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	SIGid VARCHAR(75) null,
	name VARCHAR(400) null,
	addressComplement VARCHAR(400) null,
	addressStreet VARCHAR(400) null,
	addressDistribution VARCHAR(400) null,
	addressZipCode VARCHAR(75) null,
	addressCountry VARCHAR(75) null,
	mercatorX VARCHAR(75) null,
	mercatorY VARCHAR(75) null,
	RGF93X VARCHAR(75) null,
	RGF93Y VARCHAR(75) null,
	locationId VARCHAR(75) null,
	alias_ STRING null,
	presentation TEXT null,
	serviceAndActivities TEXT null,
	characteristics TEXT null,
	subjectToPublicHoliday BOOLEAN,
	exceptionalSchedule TEXT null,
	displayEvents BOOLEAN,
	additionalInformation TEXT null,
	contenuTooltipCarto TEXT null,
	hasURLSchedule BOOLEAN,
	scheduleLinkName STRING null,
	scheduleLinkURL STRING null,
	phone VARCHAR(75) null,
	mail VARCHAR(75) null,
	siteURL STRING null,
	siteLabel STRING null,
	bookingURL STRING null,
	facebookURL STRING null,
	facebookLabel STRING null,
	instagramURL STRING null,
	instagramLabel STRING null,
	accesMap STRING null,
	access_ TEXT null,
	accessForDisabled TEXT null,
	accessForBlind BOOLEAN,
	accessForDeaf BOOLEAN,
	accessForWheelchair BOOLEAN,
	accessForElder BOOLEAN,
	accessForDeficient BOOLEAN,
	RTEnabled BOOLEAN,
	RTType VARCHAR(75) null,
	RTExternalId VARCHAR(75) null,
	RTAvailable LONG,
	RTOccupation LONG,
	RTCapacity LONG,
	RTStatus VARCHAR(75) null,
	RTLastUpdate DATE null,
	imageId LONG,
	imageWidth INTEGER,
	imageHeight INTEGER,
	imageIds VARCHAR(400) null,
	videosIds VARCHAR(400) null,
	priceId LONG,
	documentsIds VARCHAR(400) null
);

create table place_Price (
	uuid_ VARCHAR(75) null,
	priceId LONG not null primary key,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title STRING null,
	priceDescription TEXT null
);

create table place_PublicHoliday (
	uuid_ VARCHAR(75) null,
	publicHolidayId LONG not null primary key,
	name STRING null,
	date_ DATE null,
	recurrent BOOLEAN
);

create table place_ScheduleException (
	uuid_ VARCHAR(75) null,
	exceptionId LONG not null primary key,
	startDate DATE null,
	endDate DATE null,
	openingTimes VARCHAR(75) null,
	firstComment STRING null,
	secondComment STRING null,
	thirdComment STRING null,
	fourthComment STRING null,
	fifthComment STRING null,
	comment_ STRING null,
	closed BOOLEAN,
	placeId LONG,
	subPlaceId LONG
);

create table place_Slot (
	uuid_ VARCHAR(75) null,
	slotId LONG not null primary key,
	dayOfWeek LONG,
	startHour VARCHAR(75) null,
	endHour VARCHAR(75) null,
	comment_ STRING null,
	periodId LONG,
	subPlaceId LONG
);

create table place_SubPlace (
	uuid_ VARCHAR(75) null,
	subPlaceId LONG not null primary key,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name STRING null,
	description TEXT null,
	placeId LONG
);