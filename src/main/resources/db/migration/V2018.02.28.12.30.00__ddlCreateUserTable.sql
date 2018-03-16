CREATE SEQUENCE user_seq
  START WITH 1
  INCREMENT BY 10;

CREATE TABLE user (
  id     BIGINT (19) DEFAULT user_seq.nextval PRIMARY KEY,
  name   VARCHAR(255),
  e_mail VARCHAR(255)
);