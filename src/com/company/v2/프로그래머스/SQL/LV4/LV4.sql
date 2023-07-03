###
select
    com.car_id,
    com.car_type,
    round(com.daily_fee * (100 - plan.discount_rate)/100 * 30) as fee
from car_rental_company_car com
         inner join car_rental_company_discount_plan plan on com.car_type = plan.car_type
where plan.duration_type = '30일 이상'
  and com.car_type in ('세단', 'SUV')
  and com.car_id not in (
    select car_id
    from car_rental_company_rental_history
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
)
having fee >= 500000 and fee < 2000000
order by fee desc, com.car_type, com.car_id desc