CREATE TABLE Account (
  id          BIGINT (19) NOT NULL PRIMARY KEY,
  description VARCHAR(255),
  user_id     BIGINT (19)
);

ALTER TABLE Account
  ADD FOREIGN KEY (user_id) REFERENCES User (id);