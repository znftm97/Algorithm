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