SELECT AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_OUTS AO
    INNER JOIN ANIMAL_INS AI
    ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE AI.DATETIME > AO.DATETIME
ORDER BY AI.DATETIME