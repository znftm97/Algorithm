###조건에 맞는 사용자 정보 조회하기
select
    user_id,
    nickname,
    concat(city,' ',street_address1,' ',street_address2) as 전체주소,
    concat(substring(tlno,1,3),'-',substring(tlno,4,4),'-',substring(tlno,8)) as 전화번호
from used_goods_user
where user_id in (
    select writer_id
    from used_goods_board
    group by writer_id
    having count(writer_id) >= 3
)
order by user_id desc