INSERT INTO QUESTION(QUESTION_ID, TITLE, QUESTION, USERNAME) VALUES('0001', 'JAVASCRIPT', 'WHAT IS JAVASCRIPT', 'ABC');

--//@UNDO
DELETE FROM QUESTION WHERE QUESTION_ID = '0001';
