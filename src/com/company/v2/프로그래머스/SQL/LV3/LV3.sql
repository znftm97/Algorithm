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

###
select
    user.user_id,
    user.nickname,
    sum(price) as total_sales
from used_goods_user user
     inner join used_goods_board board on user.user_id = board.writer_id
where board.status = 'DONE'
group by user.user_id
having sum(price) >= 700000
order by sum(price)

###
select distinct car_id
from car_rental_company_rental_history
where car_id in (
    select car_id
    from car_rental_company_car
    where car_type = '세단'
) and month(start_date) = 10
order by car_id desc