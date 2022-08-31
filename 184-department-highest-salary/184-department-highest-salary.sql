/* Write your PL/SQL query statement below */
Select d.name as "Department" , e.name as "Employee" , e.salary as "Salary"
from Employee e , Department d
where  d.id=e.departmentId and e.salary IN (Select max(Salary) from Employee group 
                                           by departmentId having departmentid=e.departmentid)