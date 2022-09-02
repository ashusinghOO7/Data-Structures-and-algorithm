/* Write your PL/SQL query statement below */
select * from cinema where description != 'boring' and MOD(id,2) = 1 order by rating DESC