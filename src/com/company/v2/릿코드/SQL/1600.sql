#1667
select user_id, concat(substring(upper(name),1,1),
                       substring(lower(name),2)) as name
from Users
order by user_id;

#1693
select date_id,
       make_name,
       count(distinct lead_id) as unique_leads ,
       count(distinct partner_id) as unique_partners
from DailySales
group by date_id, make_name;