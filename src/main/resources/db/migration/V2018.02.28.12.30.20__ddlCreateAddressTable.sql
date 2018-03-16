CREATE SEQUENCE address_seq
  START WITH 1
  INCREMENT BY 10;


CREATE TABLE address (
  id      BIGINT (19) DEFAULT address_seq.nextval PRIMARY KEY,
  street  VARCHAR(255),
  city    VARCHAR(255),
  country VARCHAR(255)
);