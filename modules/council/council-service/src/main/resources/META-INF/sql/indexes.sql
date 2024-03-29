create index IX_24287588 on council_CouncilSession (date_);
create index IX_803633AF on council_CouncilSession (title[$COLUMN_LENGTH:75$]);
create index IX_CDB21062 on council_CouncilSession (typeId);
create index IX_A71BB2ED on council_CouncilSession (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5FDE10AF on council_CouncilSession (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B528576C on council_Deliberation (councilSessionId);
create index IX_302FDFBC on council_Deliberation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6E65253E on council_Deliberation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_263C73FD on council_Official (email[$COLUMN_LENGTH:75$]);
create index IX_E139471F on council_Official (groupId, isActive);
create index IX_C307D0A3 on council_Official (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_148223E5 on council_Official (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E00B7EA7 on council_OfficialTypeCouncil (typeId, officialId);
create index IX_EE28DC98 on council_OfficialTypeCouncil (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A4EFA91A on council_OfficialTypeCouncil (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E8C66479 on council_Procuration (councilSessionId, officialUnavailableId, isAbsent);
create index IX_818F2BBD on council_Procuration (councilSessionId, officialVotersId, officialUnavailableId);
create index IX_CA089395 on council_Procuration (officialUnavailableId, isAbsent, presential, procurationMode, startDelib, startHour);
create index IX_BF3B2FDE on council_Procuration (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AEA15E0 on council_Procuration (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_ECE0B963 on council_Type (roleId);
create index IX_1513314A on council_Type (title[$COLUMN_LENGTH:75$]);
create index IX_E9BDB672 on council_Type (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FFC53174 on council_Type (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3B3675FB on council_Vote (deliberationId, officialId);
create index IX_15E7C222 on council_Vote (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2D5E6924 on council_Vote (uuid_[$COLUMN_LENGTH:75$], groupId);