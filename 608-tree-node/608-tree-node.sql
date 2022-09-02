/* Write your PL/SQL query statement below */
Select DISTINCT t1.id as "id", (
    CASE 
    When t1.p_id is NULL then 'Root'
    When t1.p_id is NOT NULL and t2.id is NOT NULL then 'Inner'
    When t1.p_id is NOT NULL and t2.id is NULL then 'Leaf'
    END
) As "type"
from Tree t1 Left Join Tree t2
on t1.id = t2.p_id order by t1.id