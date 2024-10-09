create index IX_8AC0B357 on agenda_AgendaExport (groupId, status);
create index IX_FEBA893F on agenda_AgendaExport (status);
create unique index IX_F53FD6CF on agenda_AgendaExport (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_52D68D89 on agenda_AgendaExportPeriod (agendaExportId);
create index IX_144F1DBA on agenda_AgendaExportPeriod (uuid_[$COLUMN_LENGTH:75$]);

create index IX_75A149D3 on agenda_CacheJson (isApproved, eventId);

create index IX_33C5F7C1 on agenda_Campaign (groupId);
create index IX_B306DFDF on agenda_Campaign (title[$COLUMN_LENGTH:400$]);
create unique index IX_7CD41A7F on agenda_Campaign (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F577BCDC on agenda_CampaignEvent (campaignId);
create unique index IX_8B3A9D3 on agenda_CampaignEvent (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CDE8F146 on agenda_CampaignEventStatus (campaignEventId);
create index IX_D3F95625 on agenda_CampaignEventStatus (uuid_[$COLUMN_LENGTH:75$]);

create index IX_586159C9 on agenda_CsmapCacheJson (isActive, createEvent, hasSchedules);
create index IX_5D8B4F44 on agenda_CsmapCacheJson (isActive, createEvent, modifiedEvent, hasSchedules);
create index IX_3173BB26 on agenda_CsmapCacheJson (isActive, modifiedEvent);
create index IX_CA5F495F on agenda_CsmapCacheJson (isActive, regeneratedDate);
create index IX_5440C79D on agenda_CsmapCacheJson (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D69467AB on agenda_Event (groupId, title[$COLUMN_LENGTH:400$]);
create index IX_7ADC72A6 on agenda_Event (idSource[$COLUMN_LENGTH:75$], source[$COLUMN_LENGTH:75$]);
create index IX_8EE3FDB6 on agenda_Event (lastEndDate);
create index IX_31077546 on agenda_Event (placeSIGId[$COLUMN_LENGTH:75$]);
create index IX_675CB697 on agenda_Event (status, publicationDate);
create index IX_AF190127 on agenda_Event (status, statusDate);
create index IX_E1A6B3DB on agenda_Event (title[$COLUMN_LENGTH:400$]);
create unique index IX_519D0203 on agenda_Event (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B2EF1E05 on agenda_EventParticipation (eventId);
create index IX_CA18BE1A on agenda_EventParticipation (publikUserId[$COLUMN_LENGTH:75$], eventId);

create index IX_355794E7 on agenda_EventPeriod (campaignEventId);
create index IX_91BE1417 on agenda_EventPeriod (eventId);
create index IX_7830DF06 on agenda_EventPeriod (uuid_[$COLUMN_LENGTH:75$]);

create index IX_3DF3373E on agenda_EventToManifestation (companyId);
create index IX_E5121167 on agenda_EventToManifestation (manifestationId);

create index IX_DE6098D9 on agenda_Historic (suppressionDate);
create index IX_394F241C on agenda_Historic (uuid_[$COLUMN_LENGTH:75$]);

create index IX_303B8202 on agenda_ImportReport (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D532E9A9 on agenda_ImportReportLine (reportId);
create index IX_BC33AA75 on agenda_ImportReportLine (type_[$COLUMN_LENGTH:75$], status);
create index IX_CE752A6E on agenda_ImportReportLine (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E1C2A620 on agenda_Manifestation (endDate);
create index IX_44120AB1 on agenda_Manifestation (groupId);
create index IX_68B19732 on agenda_Manifestation (idSource[$COLUMN_LENGTH:75$], source[$COLUMN_LENGTH:75$]);
create index IX_A95B9C8B on agenda_Manifestation (status, publicationDate);
create index IX_7C3732B3 on agenda_Manifestation (status, statusDate);
create index IX_B81AEECF on agenda_Manifestation (title[$COLUMN_LENGTH:400$]);
create unique index IX_F749D98F on agenda_Manifestation (uuid_[$COLUMN_LENGTH:75$], groupId);