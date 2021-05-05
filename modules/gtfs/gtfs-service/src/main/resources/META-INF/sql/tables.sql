create table gtfs_Agency (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	agency_name VARCHAR(75) null,
	agency_url VARCHAR(400) null,
	agency_timezone VARCHAR(75) null,
	agency_phone VARCHAR(75) null,
	agency_fare_url VARCHAR(400) null,
	agency_lang VARCHAR(75) null
);

create table gtfs_Alert (
	uuid_ VARCHAR(75) null,
	alertId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	arretId LONG,
	startDate DATE null,
	endDate DATE null,
	ligneAndDirection STRING null,
	perturbation TEXT null
);

create table gtfs_Arret (
	uuid_ VARCHAR(75) null,
	arretId LONG not null primary key,
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
	stopId VARCHAR(75) null,
	title VARCHAR(75) null,
	code_ VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	type_ INTEGER
);

create table gtfs_Calendar (
	id_ LONG not null primary key,
	service_id VARCHAR(75) null,
	start_date DATE null,
	end_date DATE null
);

create table gtfs_CalendarDate (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	service_id VARCHAR(75) null,
	date_ DATE null,
	exception_type INTEGER
);

create table gtfs_Direction (
	uuid_ VARCHAR(75) null,
	directionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	tripId VARCHAR(75) null,
	stopId VARCHAR(75) null,
	routeId VARCHAR(75) null,
	destinationName VARCHAR(75) null
);

create table gtfs_ImportHistoric (
	uuid_ VARCHAR(75) null,
	importHistoricId LONG not null primary key,
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
	result INTEGER,
	operations TEXT null,
	errorDescription TEXT null,
	errorStackTrace TEXT null,
	startDate DATE null,
	finishDate DATE null,
	gtfsFileHash VARCHAR(75) null
);

create table gtfs_Ligne (
	uuid_ VARCHAR(75) null,
	ligneId LONG not null primary key,
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
	routeId VARCHAR(75) null,
	shortName VARCHAR(75) null,
	title VARCHAR(75) null,
	type_ INTEGER,
	backgroundColor VARCHAR(75) null,
	textColor VARCHAR(75) null
);

create table gtfs_Route (
	route_id VARCHAR(75) not null primary key,
	route_short_name VARCHAR(75) null,
	route_long_name VARCHAR(200) null,
	route_type INTEGER,
	route_color VARCHAR(75) null,
	route_text_color VARCHAR(75) null
);

create table gtfs_Stop (
	stop_id VARCHAR(75) not null primary key,
	stop_code VARCHAR(75) null,
	stop_lat VARCHAR(75) null,
	stop_lon VARCHAR(75) null,
	stop_name VARCHAR(75) null
);

create table gtfs_StopTime (
	trip_id VARCHAR(75) not null,
	stop_id VARCHAR(75) not null,
	primary key (trip_id, stop_id)
);

create table gtfs_Trip (
	route_id VARCHAR(75) null,
	service_id VARCHAR(75) null,
	trip_id VARCHAR(75) not null primary key,
	trip_headsign VARCHAR(75) null
);