/* Write your PL/SQL query statement below */
Select email from Person Group By email having count(*)>1;