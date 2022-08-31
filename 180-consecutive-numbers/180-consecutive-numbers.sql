/* Write your PL/SQL query statement below */
Select DISTINCT a.num as ConsecutiveNums from 
Logs a JOIN Logs b ON a.id=b.id+1 and a.num=b.num
       JOIN Logs c ON a.id=c.id+2 and a.num=c.num