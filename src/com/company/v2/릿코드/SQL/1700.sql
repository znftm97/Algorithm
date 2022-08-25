#1729
select user_id, count(follower_id) as followers_count
from Followers
group by user_id
order by user_id;

#1741
select event_day as day,
       emp_id,
       sum(out_time) - sum(in_time) as total_time
from Employees
group by emp_id, event_day

#1757
select product_id
from Products
where low_fats = 'Y' and recyclable = 'Y';

#1795
select product_id, 'store1' as store ,store1 as price
from Products
where store1 is not null
UNION
select product_id, 'store2' as store ,store2 as price
from Products
where store2 is not null
UNION
select product_id, 'store3' as store ,store3 as price
from Products
where store3 is not null