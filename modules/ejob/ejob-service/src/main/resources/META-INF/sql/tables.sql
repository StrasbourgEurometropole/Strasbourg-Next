create table ejob_Alert (
	uuid_ VARCHAR(75) null,
	alertId LONG not null primary key,
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
	name VARCHAR(75) null,
	keyWord VARCHAR(75) null,
	publikUserId VARCHAR(75) null
);

create table ejob_Offer (
	uuid_ VARCHAR(75) null,
	offerId LONG not null primary key IDENTITY,
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
	publicationId VARCHAR(75) null,
	postNumber VARCHAR(75) null,
	jobCreationDescription STRING null,
	startDate DATE null,
	motif STRING null,
	permanentDescription STRING null,
	duration STRING null,
	post STRING null,
	isFullTime BOOLEAN,
	fullTimeDescription STRING null,
	introduction TEXT null,
	activities TEXT null,
	profil TEXT null,
	conditions TEXT null,
	avantages TEXT null,
	limitDate DATE null,
	contact VARCHAR(75) null,
	emails VARCHAR(75) null,
	shareLinkedin BOOLEAN,
	exportTotem VARCHAR(75) null,
	publicationStartDate DATE null,
	publicationEndDate DATE null
);