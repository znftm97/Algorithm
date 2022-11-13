#1809 - 1
SELECT session_id
FROM Playback pb
    LEFT JOIN Ads ad ON pb.customer_id = ad.customer_id
    AND ad.timestamp BETWEEN start_time AND end_time
WHERE ad.ad_id IS NULL

#1809 - 2
SELECT session_id
FROM Playback
WHERE session_id NOT IN (
    SELECT distinct pb.session_id
    FROM Playback pb
         LEFT JOIN Ads ad ON pb.customer_id = ad.customer_id
    WHERE ad.timestamp BETWEEN pb.start_time AND pb.end_time
)

#1873
select employee_id , if((employee_id%2) = 1 and name not like 'M%', salary, 0) as bonus
from Employees
order by employee_id;

#1890
select user_id, MAX(time_stamp) as last_stamp
from Logins
where DATE_FORMAT(time_stamp, '%Y') = '2020'
group by user_id;
