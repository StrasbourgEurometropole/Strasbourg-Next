alter table agenda_Manifestation
    add externalImageThumbnailURL VARCHAR(255) null AFTER externalImageURL,
    add externalURL VARCHAR(500) null AFTER idSource;

COMMIT_TRANSACTION;