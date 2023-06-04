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
