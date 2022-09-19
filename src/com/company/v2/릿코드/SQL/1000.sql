#1050
select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having count(timestamp) >= 3;

#1068
select p.product_name as product_name,
       s.year as year,
       s.price as price
from sales s
inner join product p on s.product_id = p.product_id

#1069
select product_id, sum(quantity) as total_quantity
from sales s
group by product_id;

#1075
select p.project_id, round(avg(e.experience_years), 2) as average_years
from project p
inner join employee e on p.employee_id = e.employee_id
group by p.project_id

#1076
select project_id
from project
group by project_id
having count(employee_id) =
(
    select count(employee_id)
    from project
    group by project_id
    order by count(employee_id) desc
    limit 1
)

#1082
select seller_id
from sales
group by seller_id
having sum(price) =
(
    select sum(price)
    from sales
    group by seller_id
    order by sum(price) desc
    limit 1
);


#1084
select p.product_id, p.product_name
from Product p
         inner join Sales s on p.product_id = s.product_id
group by product_id
having min(s.sale_date) >= '2019-01-01' and
        max(s.sale_date) <= '2019-03-31';