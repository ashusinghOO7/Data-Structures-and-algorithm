/* Write your PL/SQL query statement below */
Select name as customers
from Customers
where (Customers.id Not in (Select customerId from Orders));