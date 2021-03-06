create table search_SearchLog (
	searchLogId LONG not null primary key,
	keywords VARCHAR(400) null,
	searchTime LONG,
	resultCount LONG,
	result1ClassId LONG,
	result1ClassPK LONG,
	result1Title VARCHAR(800) null,
	result2ClassId LONG,
	result2ClassPK LONG,
	result2Title VARCHAR(800) null,
	result3ClassId LONG,
	result3ClassPK LONG,
	result3Title VARCHAR(800) null,
	userTargetClassId LONG,
	userTargetClassPK LONG,
	userTargetTitle VARCHAR(800) null,
	groupId LONG,
	layoutId LONG,
	layoutFriendlyURL VARCHAR(75) null,
	language VARCHAR(75) null,
	date_ DATE null
);