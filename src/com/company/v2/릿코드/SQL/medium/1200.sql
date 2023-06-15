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

###1212
with home as(
    select
        m.host_team as team_id,
        t.team_name,
        sum(
            case when m.host_goals > m.guest_goals then 3
            when m.host_goals = m.guest_goals then 1
            else 0 end
        ) as num_points
    from matches m
    inner join teams t on m.host_team = t.team_id
    group by m.host_team
), away as(
    select
        m.guest_team as team_id,
        t.team_name,
        sum(
            case when m.guest_goals > m.host_goals then 3
            when m.guest_goals = m.host_goals then 1
            else 0 end
        ) as num_points
    from matches m
    inner join teams t on m.guest_team = t.team_id
    group by m.guest_team
)

select
    distinct t.team_id,
     t.team_name,
     ifnull(h.num_points, 0) + ifnull(a.num_points, 0) as num_points
from teams t
     left join home h on t.team_id = h.team_id
     left join away a on t.team_id = a.team_id
order by num_points desc, t.team_id

###1264
with friends as(
  select user2_id
  from friendship
  where user1_id = 1
  union
  select user1_id
  from friendship
  where user2_id = 1
)

select distinct page_id as recommended_page
from likes
where user_id in (select * from friends)
  and page_id not in (select page_id from likes where user_id = 1)

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