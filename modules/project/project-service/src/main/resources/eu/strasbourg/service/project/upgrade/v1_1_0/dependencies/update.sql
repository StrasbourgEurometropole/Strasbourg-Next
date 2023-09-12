create table project_SaisineObservatoire (
	saisineObservatoireId LONG not null primary key,
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
	title VARCHAR(400) null,
	summary VARCHAR(500) null,
	description TEXT null,
	placeTextArea VARCHAR(400) null,
	filesDownload VARCHAR(75) null,
	inTheNameOf VARCHAR(400) null,
	isOfficial BOOLEAN,
	cityResponse TEXT null,
	projectTarget TEXT null,
	petitionnaireLastname VARCHAR(75) null,
	petitionnaireFirstname VARCHAR(75) null,
	petitionnaireBirthday DATE null,
	petitionnaireAdresse VARCHAR(400) null,
	petitionnairePostalCode LONG,
	petitionnaireCity VARCHAR(400) null,
	petitionnairePhone VARCHAR(75) null,
	petitionnaireEmail VARCHAR(400) null,
	isSupported BOOLEAN,
	supportedBy VARCHAR(75) null,
	videoUrl VARCHAR(400) null,
	externalImageURL VARCHAR(400) null,
	externalImageCopyright VARCHAR(75) null,
	mediaChoice BOOLEAN,
	publikId VARCHAR(75) null,
	imageId LONG,
	filesIds VARCHAR(400) null
);

alter table project_PlacitPlace add column saisineObservatoireId LONG;

create index IX_A2FB6E19 on project_SaisineObservatoire (groupId);
create index IX_E32F07D1 on project_SaisineObservatoire (publikId[$COLUMN_LENGTH:75$]);
create index IX_5881B2F3 on project_SaisineObservatoire (status, groupId);
create index IX_E9CCEA9E on project_PlacitPlace (saisineObservatoireId);