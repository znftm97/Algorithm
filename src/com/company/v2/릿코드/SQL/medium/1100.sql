### 1107
select
    activity_date as login_date,
    count(distinct user_id) as user_count
from traffic
where datediff('2019-06-30', activity_date) <= 90
  and (user_id, activity_date) in (
    select user_id, min(activity_date)
    from traffic
    where activity = 'login'
    group by user_id
)
group by activity_date

### 1112
select
    student_id,
    min(course_id) as course_id,
    grade
from enrollments
where (student_id, grade) in (
    select student_id, max(grade)
    from enrollments
    group by student_id
)
group by student_id
order by student_id

### 1126
with occ_avg as( # event_type별 평균값
  select event_type as et, avg(occurences) as occ
  from events
  group by event_type
), res as ( # 평균보다 큰 비즈니스
  select *
  from events e
  inner join occ_avg oa on e.event_type = oa.et
  where e.occurences > oa.occ
  group by e.business_id, e.event_type
)

select business_id
from res
group by business_id
having count(business_id) >= 2

###1149
select distinct viewer_id as id
from views
group by viewer_id, view_date
having count(distinct article_id) >= 2
order by id

###1158
select
    u.user_id as buyer_id,
    u.join_date as join_date,
    count(o.order_id) as orders_in_2019
from users u
         left join orders o on u.user_id = o.buyer_id
    and o.order_date between '2019-01-01' and '2019-12-31'
group by u.user_id