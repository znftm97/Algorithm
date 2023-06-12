###1204
select person_name
from(
    select person_name, weight, turn, sum(weight) over(order by turn) as cum_sum
    from queue
) tmp
where cum_sum <= 1000
order by turn desc
limit 1;

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