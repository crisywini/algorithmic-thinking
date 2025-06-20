-- Write your PostgreSQL query statement below
SELECT e1.name as Employee
FROM Employee e1 -- Employee
JOIN Employee e2 -- Manager 
ON e1.managerId = e2.id 
WHERE e1.salary > e2.salary