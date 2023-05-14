#2142
WITH minPassengersTime AS
         (
             SELECT
                 passenger_id,
                 MIN(B.arrival_time) AS arrival_time
             FROM Passengers P
                      JOIN Buses B
                           ON P.arrival_time <= B.arrival_time
             GROUP BY passenger_id
         )

SELECT
    bus_id,
    COUNT(M.arrival_time) AS passengers_cnt
FROM Buses B
         LEFT JOIN minPassengersTime M
                   ON B.arrival_time = M.arrival_time
GROUP BY bus_id
ORDER BY bus_id;

#2112
with A as(
    select
        departure_airport as airport_id,
        flights_count
    from flights
    union all
    select
        arrival_airport as airport_id,
        flights_count
    from flights
),

 CNT as(
     select
         airport_id,
         sum(flights_count) as total_cnt
     from A
     group by airport_id
 )

select airport_id
from CNT
where total_cnt = (
    select max(total_cnt)
    from CNT
)