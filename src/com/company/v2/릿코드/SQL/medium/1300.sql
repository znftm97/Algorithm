###1308
select
    gender,
    day,
    sum(if(gender = 'F', score_points, 0)) over(order by day) as total
from scores
where gender = 'F'
group by day
union
select
    gender,
    day,
    sum(if(gender = 'M', score_points, 0)) over(order by day) as total
from scores
where gender = 'M'
group by day
order by gender, day

###1308-1
select
    gender,
    day,
    sum(score_points) over(
        partition by gender
        order by day
        ) as total
from scores
group by gender, day
order by gender, day

### 1321
with tmp as(
  select
    visited_on,
    sum(amount) amount
  from customer
  group by visited_on
)

select
    t1.visited_on,
    sum(t2.amount) as amount,
    round(avg(t2.amount), 2) as average_amount
from tmp t1
     join tmp t2 on datediff(t1.visited_on, t2.visited_on) between 0 and 6
group by t1.visited_on
having count(1) = 7
order by t1.visited_on

###1341
(
    select u.name as results
    from movieRating mr
    inner join users u on mr.user_id = u.user_id
    group by mr.user_id
    order by count(mr.user_id) desc, u.name limit 1
)
union all
(
    select m.title as results
    from movieRating mr
    inner join movies m on mr.movie_id = m.movie_id
    where mr.created_at like '2020-02%'
    group by mr.movie_id
    order by avg(mr.rating) desc, m.title limit 1
)

###1355
with max_activity as (
    select count(activity)
    from friends
    group by activity
    order by count(activity)
    limit 1
), min_activity as (
    select count(activity)
    from friends
    group by activity
    order by count(activity) desc
    limit 1
)

select distinct activity
from friends
group by activity
having count(activity) not in (
    select *
    from max_activity
    union
    select *
    from min_activity
)


#1393
select
    stock_name,
    sum( if(operation = 'Buy', -price, price) ) as capital_gain_loss
from stocks
group by stock_name