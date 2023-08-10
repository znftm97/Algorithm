### 1907
select
    'Low Salary' as category,
    count(account_id) as accounts_count
from accounts
where income < '20000'
union
select
    'Average Salary' as category,
    count(account_id) as accounts_count
from accounts
where income >= '20000' and income <= '50000'
union
select
    'High Salary' as category,
    count(account_id) as accounts_count
from accounts
where income > '50000'

### 1934
select
    s.user_id,
    round(avg(if(c.action = 'confirmed',1,0)),2) as confirmation_rate
from signups s
left join confirmations c on s.user_id = c.user_id
group by s.user_id