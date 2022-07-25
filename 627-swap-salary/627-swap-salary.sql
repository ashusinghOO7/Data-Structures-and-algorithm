/* Write your PL/SQL query statement below */
UPDATE Salary
SET sex = decode(sex,'m','f','f','m');