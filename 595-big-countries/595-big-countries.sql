/* Write your PL/SQL query statement below */
 SELECT name, population, area
 FROM World
 Where (area >= 3000000 ) 
 
 UNION

 SELECT name, population, area
 FROM World
 Where (population >=25000000);