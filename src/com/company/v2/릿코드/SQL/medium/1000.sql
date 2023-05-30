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

###1077
select p.project_id, p.employee_id
from project p
inner join employee e on p.employee_id = e.employee_id
where (p.project_id, e.experience_years) in (
    select p.project_id, max(e.experience_years)
    from project p
    inner join employee e on p.employee_id = e.employee_id
    group by p.project_id
)

###1098
select book_id, name
from books
where available_from < '2019-05-23'
      and book_id not in (
        select book_id
        from orders
        where dispatch_date between '2018-06-23' and '2019-06-23'
        group by book_id
        having sum(quantity) >= 10
    )