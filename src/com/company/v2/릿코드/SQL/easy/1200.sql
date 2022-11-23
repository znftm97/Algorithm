#1211
select
    query_name,
    round(avg(rating / position), 2) as quality,
    round(avg(rating < 3) * 100, 2) as poor_query_percentage
from
    queries
group by
    query_name

#1241
select
    distinct sub_id as post_id,
    (select count(distinct sub_id) from submissions s2 WHERE s1.sub_id = s2.parent_id) as number_of_comments
from submissions s1
where parent_id is null
order by sub_id;

#1251
select
    p.product_id,
    round
        (
                sum(p.price * us.units) / sum(us.units), 2
        ) as average_price
from prices p
inner join unitsSold us on p.product_id = us.product_id
where us.purchase_date between p.start_date and p.end_date
group by p.product_id

#1280
select st.student_id,
       st.student_name,
       su.subject_name,
       count(e.subject_name) as attended_exams
from students st
         inner join subjects su
         left join examinations e
        on st.student_id = e.student_id and su.subject_name = e.subject_name
group by st.student_id, su.subject_name
order by student_id, subject_name;

#1294
select
    c.country_name,
    case when avg(w.weather_state) >= 25 then 'Hot'
         when avg(w.weather_state) <= 15 then 'Cold'
         ELSE 'Warm' END as weather_type
from countries c
         inner join weather w on c.country_id = w.country_id
where w.day between '2019-11-01' and '2019-11-30'
group by c.country_id;

