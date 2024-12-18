INSERT INTO PLAYERS SELECT * FROM CSVREAD('~/git/samples/intuit/interview/baseball/Player.csv');

--INSERT INTO PLAYERS SELECT * FROM CSVREAD('classpath:Player.csv');