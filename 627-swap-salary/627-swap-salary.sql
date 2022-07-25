/* Write your PL/SQL query statement below */
UPDATE Salary
SET sex = DECODE(SEX,'m','f','f','m');