#511
select a.player_id, min(a.event_date) as first_login
from Activity a
group by a.player_id;

#512
select player_id, device_id
from Activity
where (player_id, event_date) in (
    select player_id, min(event_date)
    from activity
    group by player_id
)
    #577
select e.name, b.bonus
from employee e
         left join bonus b on b.empId = e.empId
where b.bonus < 1000
   or b.bonus is null;

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

#597
select ifnull(
               round(
                           count(distinct requester_id, accepter_id) /
                           (select count(distinct sender_id, send_to_id) from friendRequest), 2
                   ), 0.00
           ) as accept_rate
from requestAccepted;
