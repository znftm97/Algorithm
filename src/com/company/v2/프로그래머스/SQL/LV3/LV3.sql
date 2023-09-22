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

###
select
    distinct car_id,
     '대여중' as AVAILABILITY
from car_rental_company_rental_history
where car_id in (
    select car_id
    from car_rental_company_rental_history
    where start_date <= '2022-10-16' and end_date >= '2022-10-16'
)
union all
select
    distinct car_id,
     '대여 가능' as AVAILABILITY
from car_rental_company_rental_history
where car_id not in (
    select car_id
    from car_rental_company_rental_history
    where start_date <= '2022-10-16' and end_date >= '2022-10-16'
)
order by car_id desc

###
select
    month(start_date) as month,
    car_id,
    count(car_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where month(start_date) between 8 and 10
    group by car_id
    having count(car_id) >= 5
) and month(start_date) between 8 and 10
group by month(start_date), car_id
having count(car_id) > 0
order by month(start_date), car_id desc

###
select
    bo.category,
    sum(bs.sales) as total_sales
from book bo
     inner join book_sales bs on bo.book_id = bs.book_id
where bs.sales_date like '2022-01%'
group by bo.category
order by bo.category

###
select
    concat('/home/grep/src/', board_id,'/',file_id,file_name,file_ext) as file_path
from used_goods_file
where board_id = (
    select board_id
    from used_goods_board
    order by views desc
    limit 1
)
order by file_id desc

###
select
    user_id,
    nickname,
    concat(city, ' ', street_address1, ' ', street_address2) as '전체주소',
    concat(substring(tlno, 1, 3), '-', substring(tlno, 4,4), '-', substring(tlno, 8)) as '전화번호'
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
    gu.user_id,
    gu.nickname,
    sum(gb.price) as total_sales
from used_goods_board gb
     inner join used_goods_user gu on gb.writer_id = gu.user_id
where gb.status = 'DONE'
group by gb.writer_id
having total_sales >= 700000
order by total_sales

###
select distinct rental_his.car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY rental_his
    inner join CAR_RENTAL_COMPANY_CAR rental on rental.car_id = rental_his.car_id
where rental.car_type = '세단' and month(rental_his.start_date) = '10'
order by rental_his.car_id desc

###
select
    sb.car_id,
    if(max(sb.availability) = '대여중', '대여중', '대여 가능') as 'availability'
from (
         select
             car_id,
             case when start_date <= '2022-10-16' && end_date >= '2022-10-16' then '대여중'
                  else '대여 가능' end as 'availability'
         from CAR_RENTAL_COMPANY_RENTAL_HISTORY
     ) as sb
group by sb.car_id
order by sb.car_id desc

###
select
    month(start_date) as month,
    car_id,
    count(car_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where month(start_date) between 8 and 10
    group by car_id
    having count(car_id) >= 5
) and month(start_date) between 8 and 10
group by month(start_date), car_id
having count(car_id) > 0
order by month(start_date), car_id desc

###`
select
    b.category,
    sum(bs.sales) as total_sales
from book b
         inner join book_sales bs on b.book_id = bs.book_id
where bs.sales_date like '2022-01%'
group by b.category
order by b.category

###
select
    food_type,
    rest_id,
    rest_name,
    favorites
from rest_info
where (food_type, favorites) in (
    select food_type, max(favorites)
    from rest_info
    group by food_type
)
order by food_type desc

###
select
    order_id,
    product_id,
    date_format(out_date, '%Y-%m-%d') as out_date,
    case when out_date <= '2022-05-01' then '출고완료'
         when out_date > '2022-05-01' then '출고대기'
         else '출고미정' end as '출고여부'
from food_order
order by order_id

###
select *
from places
where host_id in (
    select host_id
    from places
    group by host_id
    having count(host_id) >= 2
)
order by id

###
select
    ai.animal_id,
    ai.name
from animal_ins ai
inner join animal_outs ao on ai.animal_id = ao.animal_id
where ai.animal_id in (
    select animal_id
    from animal_outs
)
order by datediff(ao.datetime, ai.datetime) desc
limit 2;

###
select
    ai.name,
    ai.datetime
from animal_ins ai
where ai.animal_id not in (
    select animal_id
    from animal_outs
)
order by ai.datetime
limit 3;

select
    ai.animal_id,
    ai.name
from animal_ins ai
inner join animal_outs ao on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime;

select
    animal_id,
    name
from animal_outs
where animal_id not in (
    select animal_id
    from animal_ins
)
order by animal_id