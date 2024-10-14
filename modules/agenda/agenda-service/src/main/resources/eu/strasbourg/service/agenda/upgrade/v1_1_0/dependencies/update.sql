alter table agenda_CampaignEvent
    add tagsNames VARCHAR(75) null AFTER publicsIds;

COMMIT_TRANSACTION;