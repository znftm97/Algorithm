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


#1393
select
    stock_name,
    sum( if(operation = 'Buy', -price, price) ) as capital_gain_loss
from stocks
group by stock_name