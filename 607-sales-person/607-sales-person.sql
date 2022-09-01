# Write your MySQL query statement below
Select s.name from SalesPerson s where s.sales_id NOT IN
(Select o.sales_id from Orders o where o.com_id NOT IN
(Select c.com_id from Company c where c.name!="RED"))