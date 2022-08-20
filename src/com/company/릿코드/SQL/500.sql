#511
select a.player_id, min(a.event_date) as first_login
from Activity a
group by a.player_id;

#584
select c.name
from Customer c
where c.referee_id != 2 or c.referee_id is null;

#586
select customer_number
from orders o
group by o.customer_number
order by count(o.customer_number) desc
limit 1;

#595
select w.name, w.population, w.area
from World w
where w.area >= 3000000 or w.population >= 25000000;

#596
select c.class as class
from courses c
group by c.class
having count(c.class) >= 5;