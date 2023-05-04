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

#184
select
    d.name as Department,
    e.name as Employee,
    e.salary as Salary
from Department d
         inner join Employee e on d.id = e.departmentId
where (d.id, e.salary) in (
    select departmentId, max(salary)
    from Employee
    group by departmentId
)

#180
select distinct(l1.num) as ConsecutiveNums
from logs l1, logs l2, logs l3
where (l1.id + 1 = l2.id)   &&
        (l2.id + 1 = l3.id) &&
        (l1.num = l2.num)   &&
        (l2.num = l3.num)