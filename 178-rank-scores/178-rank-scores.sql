/* Write your PL/SQL query statement below */
Select score,(Select Count(Distinct score) from Scores where score>a.score)+1 rank
from Scores a Order by score desc