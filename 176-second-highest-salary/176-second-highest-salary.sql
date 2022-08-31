/* Write your PL/SQL query statement below */
Select max(salary) as SecondHighestSalary from Employee where salary!=(Select max(salary) from Employee);