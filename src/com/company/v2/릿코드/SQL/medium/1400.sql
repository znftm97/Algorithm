### 1445
with apple as (
    select *
    from Sales
    where fruit = 'apples'
), oranges as (
    select *
    from Sales
    where fruit = 'oranges'
)

select
    a.sale_date,
    a.sold_num-o.sold_num as diff
from apple a
inner join oranges o on a.sale_date = o.sale_date

### 1454
select
    distinct l1.id,
    (select name from accounts where id = l1.id) as name
from logins l1, logins l2
where l1.id = l2.id and datediff(l1.login_date, l2.login_date) between 1 and 4
group by l1.id, l1.login_date
having count(distinct l2.login_date) = 4

