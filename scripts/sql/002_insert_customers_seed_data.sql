INSERT INTO CUSTOMERS(ID, FIRST_NAME, LAST_NAME, AGE, ADDRESS, SALARY) VALUES(1, 'John', 'Corner', 20, '#45, Terminator Street, Hollywood, USA', 10000000.24);

--//@UNDO

DELETE FROM CUSTOMERS WHERE FIRST_NAME = 'John' AND LAST_NAME = 'Corner';