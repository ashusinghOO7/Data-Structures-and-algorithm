/*
 Please write a DELETE statement and DO NOT write a SELECT statement.
 Write your PL/SQL query statement below
 */
Delete from person p where p.id <> (Select Min(id) from person where email=p.email);