INSERT INTO USER(USER_ID,PASSWORD, NAME, EMAIL_ADDR,PHONE_NUM, COUNTRY, GENDER, AGE) VALUES('USER1', 'QWERTY','ABC','ABC@GAMIL.COM','9982374762','INDIA','M','22');

--//@UNDO

DELETE FROM USER WHERE USER_ID = 'USER1' AND EMAIL_ADDR = 'ABC@GMAIL.COM';




