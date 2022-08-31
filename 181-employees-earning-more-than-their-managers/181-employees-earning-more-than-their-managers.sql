/* Write your PL/SQL query statement below */
/*Select a.name as Employee from employee a JOIN employee b
where 
a.managerid = b.id and
a.salary>b.salary  */
select e.Name as Employee
from Employee e,Employee m
where (e.ManagerId=m.Id)
and e.salary>m.salary;