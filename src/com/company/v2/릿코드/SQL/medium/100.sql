#176
SELECT IFNULL(
       (SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1), NULL) AS SecondHighestSalary

#177
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N-1;
RETURN (
    SELECT IFNULL(salary, null) AS getNthHighestSalary
    FROM Employee
    GROUP BY salary
    ORDER BY salary desc
    LIMIT 1
    OFFSET N
    );
END