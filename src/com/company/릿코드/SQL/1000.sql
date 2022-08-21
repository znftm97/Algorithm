#1050
select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having count(timestamp) >= 3;

#1084
select p.product_id, p.product_name
from Product p
         inner join Sales s on p.product_id = s.product_id
group by product_id
having min(s.sale_date) >= '2019-01-01' and
        max(s.sale_date) <= '2019-03-31';