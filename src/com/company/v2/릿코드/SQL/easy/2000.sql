#2026
SELECT problem_id
FROM Problems
WHERE (likes/(likes + dislikes)) * 100 < 60
ORDER BY problem_id

#2072 - 1
SELECT CASE
        WHEN (SELECT COUNT(student_id) FROM NewYork WHERE score >= 90) > (SELECT COUNT(student_id) FROM California WHERE score >= 90) THEN 'New York University'
        WHEN (SELECT COUNT(student_id) FROM NewYork WHERE score >= 90) < (SELECT COUNT(student_id) FROM California WHERE score >= 90) THEN 'California University'
        ELSE 'No Winner'
        END AS 'winner';

#2072 - 2
WITH T AS (
  SELECT
    (SELECT COUNT(*) FROM NewYork WHERE score >= 90) AS ny_cnt,
    (SELECT COUNT(*) FROM California WHERE score >= 90) AS ca_cnt
)

SELECT CASE
        WHEN T.ny_cnt > T.ca_cnt THEN 'New York University'
        WHEN T.ny_cnt < T.ca_cnt THEN 'California University'
        ELSE 'No Winner'
        END AS 'winner'
FROM T;

#2082
SELECT COUNT(DISTINCT customer_id) AS rich_count
FROM Store
WHERE amount > 500

#2230
CREATE PROCEDURE getUserIDs(startDate DATE, endDate DATE, minAmount INT)
BEGIN
select distinct(user_id)
from Purchases
where time_stamp between startDate and endDate
  and amount >= minAmount
order by user_id;
END

#2329
select s.user_id, sum(s.quantity * p.price) as spending
from sales s
         inner join product p on s.product_id = p.product_id
group by s.user_id
order by spending desc, user_id asc

#2339
select
    t1.team_name as home_team,
    t2.team_name as away_team
from Teams t1, Teams t2
where t1.team_name != t2.team_name;