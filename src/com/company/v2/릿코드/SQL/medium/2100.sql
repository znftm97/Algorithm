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
