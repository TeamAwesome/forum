INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('What\'s up today Lu', 'I don\'t know. You tell me Du Juan', '19-08-2012', '12:45:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 1', 'DESCRIPTION 1 for QUESTION1', '19-08-2012', '12:50:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 2', 'DESCRIPTION 2 for QUESTION1', '19-08-2012', '12:52:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 3', 'DESCRIPTION 3 for QUESTION1', '19-08-2012', '12:53:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 4', 'DESCRIPTION 4 for QUESTION1', '19-08-2012', '12:54:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 5', 'DESCRIPTION 5 for QUESTION1', '19-08-2012', '12:55:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 6', 'DESCRIPTION 6 for QUESTION1 1029 Sometimes you need to retrieve the most recently added field from a database, but you won\'t know what the ID number in the key field is. Here\'s some simple SQL to let you get the record, in Microsoft SQL and MySQL variations. It presumes you have a primary ID field (key field) with an auto-incrementing number in it. Just replace with the name of your table, and \'primaryidfield\' with the name of your primary ID field and it will give you the most recent record.', '19-08-2012', '12:57:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 7', 'DESCRIPTION 7 for QUESTION1', '19-08-2012', '12:58:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 8', 'DESCRIPTION 8 for QUESTION1', '19-08-2012', '12:59:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 9', 'DESCRIPTION 9 for QUESTION1', '19-08-2012', '15:50:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 10', 'DESCRIPTION 10 for QUESTION1', '19-08-2012', '16:04:21', 'who');

INSERT INTO QUESTION1(
    TITLE,
    DESCRIPTION,
    DATE,
    TIME,
    USER)
  VALUES('The title 11', 'DESCRIPTION 11 for QUESTION1', '19-08-2012', '16:50:21', 'who');


--//@UNDO

DELETE FROM QUESTION1 WHERE USER = 'who' AND TIME = '12:45:21' and DATE='19-08-2012';