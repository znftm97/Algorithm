#1303
select employee_id, count(team_id) over(partition by team_id) as team_size
from employee #1322

#1322
select ad_id,
       ifnull(
               round(sum(action = 'Clicked') / sum(action = 'Clicked' or action = 'Viewed') * 100, 2)
           , 0) as ctr
from ads
group by ad_id
order by ctr desc, ad_id