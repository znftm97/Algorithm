#1511
select o.customer_id, c.name
from orders o
    inner join customers c on c.customer_id = o.customer_id
    inner join product p on p.product_id = o.product_id
group by o.customer_id
having sum(if(o.order_date between '2020-06-01' and '2020-06-30', o.quantity, 0) * p.price) >= 100
   and sum(if(o.order_date between '2020-07-01' and '2020-07-31', o.quantity, 0) * p.price) >= 100

#1517
select *
from users
where mail regexp '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$';

#1527
select *
from Patients
where conditions like 'DIAB1%' or conditions like '% DIAB1%';

#1543
select
    lower(ltrim(rtrim(product_name))) as product_name,
    date_format(sale_date, '%Y-%m') as sale_date,
    count(sale_date) as total
from Sales
group by lower(trim(product_name)), date_format(sale_date, '%Y-%m')
order by product_name, sale_date;

#1581
select v.customer_id, count(v.customer_id) as count_no_trans
from Visits v
left join Transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id;

#1587
select u.name, sum(t.amount) balance
from Users u
inner join Transactions t on t.account = u.account
group by t.account
having balance >= 10000;