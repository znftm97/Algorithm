#1527
select *
from Patients
where conditions like 'DIAB1%' or conditions like '% DIAB1%';

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