/* Write your PL/SQL query statement below */
Select Person.firstName,Person.lastName,Address.city,Address.state from Person LEFT JOIN Address on Person.personId =Address.personId ;