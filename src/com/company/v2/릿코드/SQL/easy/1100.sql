#1113
select extra as report_reason, count(distinct (post_id)) as report_count
from actions
where action = 'report' and action_date = '2019-07-04'
group by extra
having extra is not null;

###1132
with spam as (
    select
        distinct actions.post_id,
                 action_date,
                 remove_date
    from actions left join removals using(post_id)
    where extra = 'spam'
), daily as (
    select
        action_date,
        100 * sum(remove_date is not null) / count(post_id) as daily_rate
    from spam
    group by action_date
)

select
    round(sum(daily_rate) / count(daily_rate), 2) as average_daily_percent
from daily

#1141
select activity_date as day , count(distinct user_id) as active_users
from Activity
where activity_date between '2019-06-28' and '2019-07-27'
group by activity_date

#1142
select ifnull(round(count(session_id) / count(distinct user_id), 2), 0.00) as average_sessions_per_user
from (
         select user_id, session_id
         from activity
         where activity_date between date_sub('2019-07-27', interval 29 day) and '2019-07-27'
         group by user_id, session_id
     ) a

#1148
select distinct author_id as id
from Views
where author_id = viewer_id
order by id;

#1173
select round(a, 2) as immediate_percentage
from
    (
        select
                (
                    select count(delivery_id)
                    from delivery
                    where order_date = customer_pref_delivery_date
                ) /
                (
                    select count(delivery_id)
                    from delivery
                ) * 100 as a
    ) t

#1173 다른풀이
select round(100 * sum(order_date = customer_pref_delivery_date) / count(*), 2) as immediate_percentage
from delivery;

#1179
select id,
       sum(case when month = 'jan' then revenue else null end) as Jan_Revenue,
       sum(case when month = 'feb' then revenue else null end) as Feb_Revenue,
       sum(case when month = 'mar' then revenue else null end) as Mar_Revenue,
       sum(case when month = 'apr' then revenue else null end) as Apr_Revenue,
       sum(case when month = 'may' then revenue else null end) as May_Revenue,
       sum(case when month = 'jun' then revenue else null end) as Jun_Revenue,
       sum(case when month = 'jul' then revenue else null end) as Jul_Revenue,
       sum(case when month = 'aug' then revenue else null end) as Aug_Revenue,
       sum(case when month = 'sep' then revenue else null end) as Sep_Revenue,
       sum(case when month = 'oct' then revenue else null end) as Oct_Revenue,
       sum(case when month = 'nov' then revenue else null end) as Nov_Revenue,
       sum(case when month = 'dec' then revenue else null end) as Dec_Revenue
from department
group by id
order by id