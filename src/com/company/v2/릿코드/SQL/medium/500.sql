select name
from employee
where id in (
    select managerId
    from employee
    group by managerId
    having count(managerId) >= 5
)

#534
select
    a1.player_id,
    a1.event_date,
    (
        select sum(a2.games_played)
        from activity a2
        where a1.player_id = a2.player_id and a1.event_date >= a2.event_date
    ) as games_played_so_far
from activity a1

#550
select
    round( count(distinct player_id) / (select count(distinct player_id) from activity) , 2) as fraction
from activity
where (player_id, event_date) in (
    select player_id, date_add(min(event_date), interval 1 day)
    from activity
    group by player_id
)

#574
with t as (
    select candidateId, count(candidateId) cnt
    from vote
    group by candidateId
    order by cnt desc
    limit 1
)

select c.name as name
from candidate c
inner join t on c.id = t.candidateId;