ALTER TABLE official_official ADD COLUMN listeContact varchar(2000) AFTER contact;
ALTER TABLE official_official ADD COLUMN resumeFonction STRING AFTER listeContact;
COMMIT_TRANSACTION;