create table notif_Message (
	messageId LONG not null primary key,
	serviceId LONG,
	content STRING null
);

create table notif_NatureNotif (
	natureId LONG not null primary key,
	serviceId LONG,
	name STRING null
);

create table notif_Notification (
	uuid_ VARCHAR(75) null,
	notificationId LONG not null primary key,
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
	serviceId LONG,
	isAlert INTEGER,
	natureId LONG,
	title STRING null,
	subtitle STRING null,
	startDate DATE null,
	endDate DATE null,
	broadcastDate DATE null,
	messageId LONG,
	content STRING null,
	labelUrl STRING null,
	url STRING null,
	typeBroadcast LONG,
	district LONG,
	broadcastChannels VARCHAR(75) null,
	sendStatusCsmap LONG,
	sendStatusTwitter LONG,
	sendStatusMonst LONG,
	sendStatusMail LONG,
	sendStatusSegur LONG,
	isSend BOOLEAN
);

create table notif_ServiceNotif (
	serviceId LONG not null primary key,
	organisationId LONG,
	name VARCHAR(400) null,
	pictoId LONG,
	csmapSubscriptionLabel VARCHAR(200) null,
	csmapSubscriptionMandatory BOOLEAN,
	csmapTopic VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);