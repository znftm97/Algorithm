#1407
select u.name, ifnull(sum(r.distance), 0) as travelled_distance
from Users u
left join Rides r on u.id = r.user_id
group by r.user_id
order by travelled_distance desc, name asc;

#1421
select q.id as id, q.year as year, ifnull(n.npv, 0) as npv
from queries q
    left join npv n on n.id = q.id and n.year = q.year

#1435
select "[0-5>" as bin, count(*) as total from Sessions where duration/60 < 5
union
select "[5-10>", count(*) from Sessions where duration/60 >= 5 and duration/60 < 10
union
select "[10-15>", count(*) from Sessions where duration/60 >= 10 and duration/60 < 15
union
select "15 or more", count(*) from Sessions where duration/60 >= 15;



#1484
select sell_date,
       count(distinct product) as num_sold,
       group_concat(distinct product) as products
from Activities
group by sell_date
order by sell_date
