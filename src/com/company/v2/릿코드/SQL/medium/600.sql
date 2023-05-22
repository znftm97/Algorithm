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

###602
with re as( #requester_id 기준 카운팅
    select requester_id, count(requester_id) as re_cnt
    from requestAccepted
    group by requester_id
), ac as( #accepter_id 기준 카운팅
    select accepter_id, count(accepter_id) as ac_cnt
    from requestAccepted
    group by accepter_id
), unions as( #두 임시테이블 union all (개수는 중복가능하기때문에 all)
    select *
    from re r
    union all
    select *
    from ac a
)

select
   requester_id as id,
   sum(re_cnt) as num
from unions
group by requester_id
order by num desc
limit 1;