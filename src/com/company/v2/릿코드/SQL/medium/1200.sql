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