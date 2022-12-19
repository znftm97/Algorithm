#175
select p.firstName, p.lastName, a.city, a.state
from Person p
left join Address a on p.personId = a.personId;

#181
select e1.name as Employee
from Employee as e1
join Employee as e2 on e1.managerId = e2.id
where e1.salary > e2.salary;

#182
select p.email as Email
from Person p
group by p.email
having count(p.email) > 1;

#183
select c.name as Customers
from Customers c
left join Orders o on c.id = o.customerId
where isnull(o.customerId); // where o.customerId is null

#196
delete from Person
where id not in (
    select min(p.id) from (
      select * from Person
    ) p
    group by p.email
);

#197
SELECT a.Id
FROM Weather a
JOIN Weather b
WHERE a.Temperature > b.Temperature
AND DATEDIFF(a.Recorddate, b.Recorddate) = 1