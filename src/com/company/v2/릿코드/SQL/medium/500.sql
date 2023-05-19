select name
from employee
where id in (
    select managerId
    from employee
    group by managerId
    having count(managerId) >= 5
)

###534
select
    a1.player_id,
    a1.event_date,
    (
        select sum(a2.games_played)
        from activity a2
        where a1.player_id = a2.player_id and a1.event_date >= a2.event_date
    ) as games_played_so_far
from activity a1

###550
select
    round( count(distinct player_id) / (select count(distinct player_id) from activity) , 2) as fraction
from activity
where (player_id, event_date) in (
    select player_id, date_add(min(event_date), interval 1 day)
    from activity
    group by player_id
)

###574
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

###578
# 질문 개수
with question as (
    select question_id, count(question_id) as question_cnt
    from surveylog
    where action = 'show'
    group by question_id
),
# 응답 개수
answer as (
    select question_id, count(question_id) as answer_cnt
    from surveylog
    where action = 'answer'
    group by question_id
)

# (응답 / 질문)
select s.question_id as survey_log
from surveylog s
         left join question q on s.question_id = q.question_id
         left join answer a on s.question_id = a.question_id
group by s.question_id
order by (a.answer_cnt / q.question_cnt) desc, s.question_id
limit 1;