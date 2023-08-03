###
select
    board_id,
    writer_id,
    title,
    price,
    case status when 'sale' then '판매중'
                when 'reserved' then '예약중'
                else '거래완료' end
from used_goods_board
where created_date = '2022-10-05'
order by board_id desc

###
select
    b.book_id,
    a.author_name,
    date_format(b.published_date, '%Y-%m-%d') as published_date
from book b
         inner join author a on b.author_id = a.author_id
where b.category = '경제'
order by b.published_date

###
select
    i.ingredient_type,
    sum(f.total_order) as total_order
from first_half f
     inner join icecream_info i on f.flavor = i.flavor
group by i.ingredient_type
order by total_order

###
select
    mcdp_cd as '진료과코드',
    count(apnt_ymd) as '5월예약건수'
from appointment
where apnt_ymd like '2022-05%'
group by mcdp_cd
order by count(apnt_no), mcdp_cd

###
select user_id, product_id
from online_sale
group by user_id, product_id
having count(online_sale_id) >= 2
order by user_id, product_id desc

###
select
    p.product_code,
    sum(p.price * os.sales_amount) as sales
from product p
inner join offline_sale os on p.product_id = os.product_id
group by p.product_code
order by sales desc, p.product_code

###
select
    (price - price%10000) as price_group,
    count(*) as products
from product
group by price_group
order by price_group

###
select
    substring(product_code, 1, 2) as category,
    count(*) as products
from product
group by category
order by category

###
select
    member_id,
    member_name,
    gender,
    date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
from member_profile
where month(date_of_birth) = 3 and gender = 'w' and tlno is not null
order by member_id

###
select *
from food_product
where price = (
    select price
    from food_product
    order by price desc
    limit 1
)

###
select
    animal_id,
    name,
    if(sex_upon_intake like '%neutered%' or sex_upon_intake like '%spayed%', 'O', 'X') as '중성화'
from animal_ins
order by animal_id