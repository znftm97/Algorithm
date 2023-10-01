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

###
select
    a.author_id,
    a.author_name,
    b.category,
    sum(bs.sales * b.price) as total_sales
from book_sales bs
     inner join book b on bs.book_id = b.book_id
     inner join author a on b.author_id = a.author_id
where year(bs.sales_date) = '2022' and month(bs.sales_date) = '01'
group by a.author_name, b.category
order by a.author_id, b.category desc

###
with jul as (
    select flavor, sum(total_order) as total
    from july
    group by flavor
), hal as (
    select flavor, total_order as total
    from first_half
)

select j.flavor
from jul j
     inner join hal h on j.flavor = h.flavor
order by j.total + h.total desc
limit 3;

###
select
    ap.apnt_no,
    pa.pt_name,
    pa.pt_no,
    ap.mcdp_cd,
    do.dr_name,
    ap.apnt_ymd
from appointment ap
     inner join patient pa on pa.pt_no = ap.pt_no
     inner join doctor do on do.dr_id = ap.mddr_id
where ap.apnt_ymd like '2022-04-13%'
  and ap.apnt_cncl_yn = 'N'
  and ap.mcdp_cd = 'CS'
order by ap.apnt_ymd

###
select
    date_format(sales_date, '%Y-%m-%d') as sales_date,
    product_id,
    user_id,
    sales_amount
from online_sale
where sales_date like '2022-03%'
union
select
    date_format(sales_date, '%Y-%m-%d') as sales_date,
    product_id,
    null,
    sales_amount
from offline_sale
where sales_date like '2022-03%'
order by sales_date, product_id, user_id

###
select
    year(os.sales_date) as year,
    month(os.sales_date) as month,
    ui.gender,
    count(distinct os.user_id) as users
from user_info ui
     inner join online_sale os on ui.user_id = os.user_id
where ui.gender is not null
group by year, month, ui.gender
order by year, month, ui.gender

###
select
    me.member_name,
    re.review_text,
    date_format(re.review_date, '%Y-%m-%d') as review_date
from rest_review re
     inner join member_profile me on re.member_id = me.member_id
where re.member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(review_id) desc
    limit 1
)
order by re.review_date, re.review_text

###
select
    car.car_id,
    car.car_type,
    round(car.daily_fee * (100 - plan.discount_rate)/100 * 30) as fee
from CAR_RENTAL_COMPANY_CAR car
         inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan on car.car_type = plan.car_type
where car.car_type in ('세단', 'SUV')
  and plan.duration_type = '30일 이상'
  and car.car_id not in (
    select car_id
    from car_rental_company_rental_history
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
)
having fee >= 500000 and fee < 2000000
order by fee desc, car.car_type asc, car.car_id desc