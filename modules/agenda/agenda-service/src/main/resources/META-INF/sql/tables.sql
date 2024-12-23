create table agenda_AgendaExport (
	uuid_ VARCHAR(75) null,
	agendaExportId LONG not null primary key,
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
	title STRING null,
	language VARCHAR(75) null,
	exportFormat VARCHAR(75) null,
	templateId LONG,
	eventCategories TEXT null,
	aggregations TEXT null
);

create table agenda_AgendaExportPeriod (
	uuid_ VARCHAR(75) null,
	agendaExportPeriodId LONG not null primary key,
	startDate DATE null,
	endDate DATE null,
	agendaExportId LONG
);

create table agenda_CacheJson (
	eventId LONG not null primary key,
	jsonEvent TEXT null,
	createEvent DATE null,
	modifiedEvent DATE null,
	isApproved BOOLEAN
);

create table agenda_Campaign (
	uuid_ VARCHAR(75) null,
	campaignId LONG not null primary key,
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
	title STRING null,
	defaultImageId LONG,
	defaultImageCopyright STRING null,
	managersIds VARCHAR(75) null,
	exportEnabled BOOLEAN,
	startDate DATE null,
	endDate DATE null,
	provider VARCHAR(20) null
);

create table agenda_CampaignEvent (
	uuid_ VARCHAR(75) null,
	campaignEventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	serviceId LONG,
	service VARCHAR(75) null,
	onSiteFirstName VARCHAR(75) null,
	onSiteLastName VARCHAR(75) null,
	onSitePhone VARCHAR(75) null,
	title STRING null,
	subtitle STRING null,
	description TEXT null,
	imageId LONG,
	webImageId LONG,
	imageOwner VARCHAR(75) null,
	manifestationsIds VARCHAR(75) null,
	placeSIGId VARCHAR(75) null,
	placeName STRING null,
	placeStreetNumber VARCHAR(75) null,
	placeStreetName VARCHAR(75) null,
	placeZipCode VARCHAR(75) null,
	placeCityId LONG,
	placeCountry VARCHAR(75) null,
	promoter VARCHAR(75) null,
	publicPhone VARCHAR(75) null,
	publicEmail VARCHAR(75) null,
	websiteURL STRING null,
	websiteName STRING null,
	free INTEGER,
	price TEXT null,
	campaignId LONG,
	themesIds VARCHAR(75) null,
	typesIds VARCHAR(75) null,
	publicsIds VARCHAR(75) null,
	tagsNames VARCHAR(75) null,
	bookingDescription TEXT null,
	bookingURL VARCHAR(400) null,
	registration BOOLEAN,
	registrationStartDate DATE null,
	registrationEndDate DATE null,
	maxGauge LONG
);

create table agenda_CampaignEventStatus (
	uuid_ VARCHAR(75) null,
	statusId LONG not null primary key,
	status INTEGER,
	comment_ TEXT null,
	deletionDenied BOOLEAN,
	date_ DATE null,
	campaignEventId LONG,
	previousStatusId LONG,
	userId LONG,
	userName VARCHAR(75) null
);

create table agenda_CsmapCacheJson (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	jsonEvent TEXT null,
	createEvent DATE null,
	modifiedEvent DATE null,
	isActive BOOLEAN,
	regeneratedDate DATE null,
	hasSchedules BOOLEAN
);

create table agenda_Event (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
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
	title STRING null,
	subtitle STRING null,
	description TEXT null,
	externalImageURL VARCHAR(255) null,
	externalImageThumbnailURL VARCHAR(255) null,
	externalImageCopyright VARCHAR(400) null,
	imageWidth INTEGER,
	imageHeight INTEGER,
	placeSIGId VARCHAR(75) null,
	placeName STRING null,
	placeStreetNumber VARCHAR(75) null,
	placeStreetName VARCHAR(75) null,
	placeZipCode VARCHAR(75) null,
	placeCity VARCHAR(75) null,
	placeCountry VARCHAR(75) null,
	mercatorX VARCHAR(75) null,
	mercatorY VARCHAR(75) null,
	access_ TEXT null,
	accessForDisabled TEXT null,
	accessForBlind BOOLEAN,
	accessForDeaf BOOLEAN,
	accessForWheelchair BOOLEAN,
	accessForElder BOOLEAN,
	accessForDeficient BOOLEAN,
	promoter VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	websiteURL STRING null,
	websiteName STRING null,
	free INTEGER,
	price TEXT null,
	bookingDescription TEXT null,
	bookingURL VARCHAR(400) null,
	subscriptionURL VARCHAR(400) null,
	source VARCHAR(75) null,
	idSource VARCHAR(75) null,
	publicationDate DATE null,
	distribution STRING null,
	composer VARCHAR(400) null,
	concertId VARCHAR(75) null,
	program TEXT null,
	firstStartDate DATE null,
	lastEndDate DATE null,
	createDateSource DATE null,
	modifiedDateSource DATE null,
	imageId LONG,
	registration BOOLEAN,
	registrationStartDate DATE null,
	registrationEndDate DATE null,
	maxGauge LONG
);

create table agenda_EventParticipation (
	eventParticipationId LONG not null primary key,
	createDate DATE null,
	publikUserId VARCHAR(75) null,
	eventId LONG,
	groupId LONG
);

create table agenda_EventPeriod (
	uuid_ VARCHAR(75) null,
	eventPeriodId LONG not null primary key,
	startDate DATE null,
	endDate DATE null,
	timeDetail STRING null,
	eventId LONG,
	campaignEventId LONG
);

create table agenda_EventToManifestation (
	companyId LONG not null,
	eventId LONG not null,
	manifestationId LONG not null,
	primary key (eventId, manifestationId)
);

create table agenda_Historic (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	title VARCHAR(75) null,
	suppressionDate DATE null
);

create table agenda_ImportReport (
	uuid_ VARCHAR(75) null,
	reportId LONG not null primary key,
	provider VARCHAR(400) null,
	filename VARCHAR(75) null,
	status LONG,
	globalErrorCause VARCHAR(75) null,
	newEventsCount LONG,
	modifiedEventsCount LONG,
	errorEventsCount LONG,
	unmodifiedEventsCount LONG,
	deletedEventsCount LONG,
	newManifestationsCount LONG,
	modifiedManifestationsCount LONG,
	errorManifestationsCount LONG,
	unmodifiedManifestationsCount LONG,
	deletedManifestationsCount LONG,
	startDate DATE null,
	endDate DATE null
);

create table agenda_ImportReportLine (
	uuid_ VARCHAR(75) null,
	lineId LONG not null primary key,
	type_ VARCHAR(75) null,
	status LONG,
	log_ TEXT null,
	entityName VARCHAR(200) null,
	entityExternalId VARCHAR(75) null,
	entityId LONG,
	reportId LONG
);

create table agenda_Manifestation (
	uuid_ VARCHAR(75) null,
	manifestationId LONG not null primary key,
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
	imageId LONG,
	title STRING null,
	description TEXT null,
	externalImageURL VARCHAR(75) null,
	externalImageCopyright VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	source VARCHAR(75) null,
	idSource VARCHAR(75) null,
	publicationDate DATE null,
	createDateSource DATE null,
	modifiedDateSource DATE null
);