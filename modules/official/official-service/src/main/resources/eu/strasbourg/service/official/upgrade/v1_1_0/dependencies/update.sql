ALTER TABLE official_Official ADD COLUMN listeContact varchar(2000) AFTER contact;
ALTER TABLE official_Official ADD COLUMN resumeFonction STRING AFTER listeContact;
COMMIT_TRANSACTION;