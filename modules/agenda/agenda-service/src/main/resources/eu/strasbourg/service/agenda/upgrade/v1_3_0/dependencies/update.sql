alter table agenda_Event
    add externalImageThumbnailURL VARCHAR(255) null AFTER externalImageURL;

COMMIT_TRANSACTION;