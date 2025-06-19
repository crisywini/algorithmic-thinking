-- Write your PostgreSQL query statement below
SELECT DISTINCT num AS ConsecutiveNums

FROM (SELECT 
    num AS num,
  LEAD(num, 1) OVER (ORDER BY id) AS next1,
  LEAD(num, 2) OVER (ORDER BY id) AS next2
FROM Logs) sub 
WHERE num = next1 AND num = next2
