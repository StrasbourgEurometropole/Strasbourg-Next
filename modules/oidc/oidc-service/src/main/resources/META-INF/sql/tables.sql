create table publik_PublikUser (
	uuid_ VARCHAR(75) null,
	publikUserLiferayId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	userName VARCHAR(75) null,
	publikId VARCHAR(200) null,
	accessToken VARCHAR(200) null,
	firstName VARCHAR(200) null,
	lastName VARCHAR(200) null,
	email VARCHAR(75) null,
	mapConfig VARCHAR(1000) null,
	displayConfig VARCHAR(1000) null,
	pactSignature DATE null,
	banishDate DATE null,
	banishDescription TEXT null,
	imageURL VARCHAR(400) null
);