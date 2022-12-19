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

#1327
select p.product_name, sum(o.unit) as unit
from products p
         inner join orders o on p.product_id = o.product_id
where month(order_date) = 2 and year(order_date) = '2020'
group by o.product_id
having sum(o.unit) >= 100

#1350
select s.id, s.name
from students s
         left join departments d on d.id = s.department_id
where d.id is null

#1378
select eu.unique_id, e.name
from employees e
         left join employeeuni eu on e.id = eu.id
