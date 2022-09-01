# Write your MySQL query statement below
Select a.id from Weather as a JOIN Weather as b where DATEDIFF(a.recordDate,b.recordDate)=1 and a.temperature>b.temperature;