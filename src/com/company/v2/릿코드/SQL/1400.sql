#1407
select u.name, ifnull(sum(r.distance), 0) as travelled_distance
from Users u
left join Rides r on u.id = r.user_id
group by r.user_id
order by travelled_distance desc, name asc;

#1484
select sell_date,
       count(distinct product) as num_sold,
       group_concat(distinct product) as products
from Activities
group by sell_date
order by sell_date
