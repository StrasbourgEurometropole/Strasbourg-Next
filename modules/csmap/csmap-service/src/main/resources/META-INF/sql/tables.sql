create table csmap_Agenda (
	uuid_ VARCHAR(75) null,
	agendaId LONG not null primary key,
	title STRING null,
	editorialTitle STRING null,
	subtitle STRING null,
	imageId LONG,
	isPrincipal BOOLEAN,
	isActive BOOLEAN,
	campaignsIds STRING null,
	themesIds STRING null,
	typesIds STRING null,
	tags STRING null
);

create table csmap_BaseNonce (
	baseNonceId LONG not null primary key,
	createDate DATE null,
	value VARCHAR(75) null
);

create table csmap_PlaceCategories (
	uuid_ VARCHAR(75) null,
	placeCategoriesId LONG not null primary key,
	categoriesIds STRING null
);

create table csmap_RefreshToken (
	uuid_ VARCHAR(75) null,
	refreshTokenId LONG not null primary key,
	createDate DATE null,
	value VARCHAR(300) null,
	publikId VARCHAR(200) null
);

create table csmap_Thematic (
	uuid_ VARCHAR(75) null,
	thematicId LONG not null primary key,
	name VARCHAR(75) null,
	favorite STRING null,
	topics STRING null
);