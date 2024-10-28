alter table agenda_CampaignEvent
    add externalImageThumbnailURL VARCHAR(255) null AFTER externalImageURL;

COMMIT_TRANSACTION;