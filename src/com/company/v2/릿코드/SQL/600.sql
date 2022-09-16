#603
select distinct a.seat_id
from cinema a join cinema b
where abs(a.seat_id - b.seat_id) = 1
  and a.free = true
  and b.free = true
order by a.seat_id;

#607
select s.name
from SalesPerson s
where s.sales_id not in (
    select o.sales_id
    from Orders o
    left join Company c on c.com_id = o.com_Id
    where c.name = 'RED'
);

#620
select *
from Cinema c
where (c.id%2) = 1 and c.description != 'boring'
order by c.rating desc;

#627
update Salary
set sex = IF(sex = 'm', 'f', 'm')