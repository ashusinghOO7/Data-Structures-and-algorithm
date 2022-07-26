/*
 Please write a DELETE statement and DO NOT write a SELECT statement.
 Write your PL/SQL query statement below
 */
Delete from person p where p.id not in (Select Min(id) from person group by email);