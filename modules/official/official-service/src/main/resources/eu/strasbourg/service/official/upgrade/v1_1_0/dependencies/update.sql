ALTER TABLE official_official ADD COLUMN listeContact varchar(2000) AFTER contact;
ALTER TABLE official_official ADD COLUMN resumeFonction varchar(2000) AFTER listeContact;
COMMIT_TRANSACTION;
UPDATE official_official SET resumeFonction = "";
UPDATE official_official SET listeContact = "";
COMMIT_TRANSACTION;