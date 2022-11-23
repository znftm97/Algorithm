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