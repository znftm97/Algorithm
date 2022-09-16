#1873
select employee_id , if((employee_id%2) = 1 and name not like 'M%', salary, 0) as bonus
from Employees
order by employee_id;

#1890
select user_id, MAX(time_stamp) as last_stamp
from Logins
where DATE_FORMAT(time_stamp, '%Y') = '2020'
group by user_id;
