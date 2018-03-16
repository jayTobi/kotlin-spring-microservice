CREATE SEQUENCE account_seq
  START WITH 1
  INCREMENT BY 10;

CREATE TABLE account (
  id          BIGINT (19) DEFAULT account_seq.nextval PRIMARY KEY,
  description VARCHAR(255),
  user_id     BIGINT (19)
);

ALTER TABLE account
  ADD FOREIGN KEY (user_id) REFERENCES user (id);