#608
select
    id,
    case when p_id is null then 'Root'
         when id in (select p_id from tree) then 'Inner'
         else 'Leaf'
        end as type
from tree

#626
select
    case when id % 2 = 1 and id = (select count(id) from seat) then id
     when id % 2 = 1 then id + 1
     else id - 1
end as id,
    student
from seat
order by id;