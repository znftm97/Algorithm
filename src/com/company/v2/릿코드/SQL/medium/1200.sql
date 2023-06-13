###1204
select person_name
from(
    select person_name, weight, turn, sum(weight) over(order by turn) as cum_sum
    from queue
) tmp
where cum_sum <= 1000
order by turn desc
limit 1;

###1205
with cte as (
    select id, country, state, amount, date_format(trans_date, '%Y-%m') as month
    from transactions
    where state = 'approved'
    union all
    select trans_id as id, country, 'chargeback' as state, amount, date_format(c.trans_date, '%Y-%m') as month
    from chargebacks c
    left join transactions t on c.trans_id = t.id
)

select
    month,
    country,
    sum(if(state = 'approved', 1, 0)) as approved_count,
    sum(if(state = 'approved', amount, 0)) as approved_amount,
    sum(if(state = 'chargeback', 1, 0)) as chargeback_count,
    sum(if(state = 'chargeback', amount, 0)) as chargeback_amount
from cte
group by month, country


#1285
select
    min(log_id) as start_id,
    max(log_id) as end_id
from(
        select
            log_id,
            row_number() over(order by log_id) as rn
        from logs
    ) as a
group by log_id - rn