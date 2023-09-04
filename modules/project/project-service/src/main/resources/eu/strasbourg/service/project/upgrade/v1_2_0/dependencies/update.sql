ALTER TABLE project_SaisineObservatoire DROP COLUMN summary;
ALTER TABLE project_SaisineObservatoire DROP COLUMN inTheNameOf;
ALTER TABLE project_SaisineObservatoire DROP COLUMN isOfficial;
ALTER TABLE project_SaisineObservatoire DROP COLUMN isSupported;
ALTER TABLE project_SaisineObservatoire DROP COLUMN supportedBy;

ALTER TABLE project_SaisineObservatoire ADD otherMechanism VARCHAR(75) null;
ALTER TABLE project_SaisineObservatoire ADD collectiveName VARCHAR(75) null;

COMMIT_TRANSACTION;