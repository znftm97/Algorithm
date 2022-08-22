#1141
select activity_date as day , count(distinct user_id) as active_users
from Activity
where activity_date between '2019-06-28' and '2019-07-27'
group by activity_date

#1148
select distinct author_id as id
from Views
where author_id = viewer_id
order by id;

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