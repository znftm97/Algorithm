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

#1393
select
    stock_name,
    sum( if(operation = 'Buy', -price, price) ) as capital_gain_loss
from stocks
group by stock_name