###1045
select customer_id
from customer
group by customer_id
having count(distinct product_key) = (
    select count(product_key)
    from product
)

###1070
select
    product_id,
    year as first_year,
    quantity,
    price
from sales
where (product_id, year) in (
    select product_id, min(year)
    from sales
    group by product_id
)