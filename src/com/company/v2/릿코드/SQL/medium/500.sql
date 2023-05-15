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