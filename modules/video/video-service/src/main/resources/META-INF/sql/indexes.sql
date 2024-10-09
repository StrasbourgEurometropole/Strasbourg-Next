create index IX_B21BE7AD on video_Video (groupId);
create index IX_47640187 on video_Video (status, publicationDate);
create unique index IX_2158A913 on video_Video (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E5DE2909 on video_VideoGallery (groupId);
create index IX_D5900AE3 on video_VideoGallery (status, publicationDate);
create unique index IX_10A76837 on video_VideoGallery (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_19F21359 on video_VideoToVideoGallery (companyId);
create index IX_B823DBAE on video_VideoToVideoGallery (galleryId);