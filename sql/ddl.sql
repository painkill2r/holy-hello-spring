DROP TABLE IF EXISTS MEMBER CASCADE;
CREATE TABLE MEMBER
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255),
    PRIMARY KEY (ID)
);

INSERT INTO MEMBER (name)
VALUES ('spring'),
       ('spring2');

SELECT *
FROM MEMBER;

