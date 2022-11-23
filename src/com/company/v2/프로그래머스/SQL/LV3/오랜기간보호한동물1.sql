SELECT name, datetime
FROM ANIMAL_INS
WHERE animal_id NOT IN (
    SELECT animal_id
    FROM ANIMAL_OUTS
)
ORDER BY datetime
LIMIT 3

---

SELECT AI.name, AI.datetime
FROM ANIMAL_INS AI
    LEFT JOIN ANIMAL_OUTS AO
    ON AI.animal_id = AO.animal_id
WHERE AO.animal_id IS NULL
ORDER BY datetime
LIMIT 3