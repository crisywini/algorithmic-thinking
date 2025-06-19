-- Runtime: 212ms
--Beats
--72.52%


CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  IF N < 1 THEN
   return QUERY SELECT NULL::INT;
  ELSE 
   RETURN QUERY 
   SELECT s AS salary FROM (SELECT DISTINCT e.salary s
            FROM Employee e
            ORDER BY s DESC
            LIMIT 1 OFFSET N-1)  AS SecondHighestSalary;
  END IF;
END;
$$ LANGUAGE plpgsql;


