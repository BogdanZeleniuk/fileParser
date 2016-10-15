DROP TABLE IF EXISTS files;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START 1;

CREATE TABLE files
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  content BYTEA NOT NULL
);
CREATE UNIQUE INDEX files_unique_idx ON files(id);