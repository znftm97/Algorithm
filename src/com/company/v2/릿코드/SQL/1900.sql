#1939
SELECT DISTINCT c1.user_id
FROM confirmations c1, confirmations c2
WHERE c1.user_id = c2.user_id
  AND TIMESTAMPDIFF(SECOND, c1.time_stamp, c2.time_stamp) <= 86400
  AND TIMESTAMPDIFF(SECOND, c1.time_stamp, c2.time_stamp) > 0

#1965
select *
from (
     select e.employee_id
     from Employees e
     left join Salaries s on e.employee_id = s.employee_id
     where s.salary is null
     union
     select s.employee_id
     from Salaries s
     left join Employees e on s.employee_id = e.employee_id
     where e.name is null
) a
order by employee_id
