#1607
select s.seller_name
from seller s
where s.seller_name not in (
        select s.seller_name
        from orders o
             left join seller s on o.seller_id = s.seller_id
        where year(o.sale_date) = '2020'
    )
order by s.seller_name

#1623
select
    a.student_name as member_A,
    b.student_name as member_B,
    c.student_name as member_C
from SchoolA a, SchoolB b, SchoolC c
where a.student_id != b.student_id and
      b.student_id != c.student_id and
      a.student_id != c.student_id and
      a.student_name != b.student_name and
      b.student_name != c.student_name and
      a.student_name != c.student_name

#1633
select
    r.contest_id,
    round( count(r.user_id) / (select count(user_id) from users) * 100, 2) as percentage
from register r
group by r.contest_id
order by percentage desc, r.contest_id asc;

#1661 - 1
SELECT
    machine_id,
    ROUND(
        ( SUM(CASE WHEN activity_type = 'end' THEN timestamp END) - SUM(CASE WHEN activity_type = 'start' THEN timestamp END) ) / COUNT(DISTINCT process_id), 3
    ) as processing_time
FROM Activity
GROUP BY machine_id

#1661 - 2
SELECT
    machine_id,
    ROUND(
        ( SUM(IF(activity_type = 'end', timestamp, 0)) - SUM(IF(activity_type = 'start', timestamp, 0)) ) / COUNT(DISTINCT process_id), 3
    ) as processing_time
FROM Activity
GROUP BY machine_id

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