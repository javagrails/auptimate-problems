CREATE TABLE public.transaction_history (
  id bigserial NOT NULL,
  investor_id int8 NOT NULL,
  syndicate_id int8 NOT NULL,
  transaction_amount float8 NOT NULL,
  transaction_date timestamp NULL,
  CONSTRAINT transaction_history_pkey PRIMARY KEY (id)
);

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (1,1,10,NOW()),
       (1,1,10,NOW()),
       (1,2,20,NOW()),
       (1,3,30,NOW());

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (2,1,10,NOW()),
       (2,1,10,NOW()),
       (2,2,20,NOW()),
       (2,3,30,NOW()),
       (2,4,40,NOW());

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (3,3,30,NOW()),
       (3,4,40,NOW()),
       (3,5,50,NOW()),
       (3,6,60,NOW()),
       (3,7,70,NOW()),
       (3,8,80,NOW());

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (4,3,30,NOW()),
       (4,3,30,NOW()),
       (4,3,30,NOW()),
       (4,3,30,NOW()),
       (4,3,30,NOW()),
       (4,3,30,NOW());

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (6,1,10,NOW()),
       (6,4,40,NOW()),
       (6,5,50,NOW()),
       (6,4,40,NOW()),
       (6,7,70,NOW()),
       (6,9,90,NOW()),
       (6,8,80,NOW());

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (11,4,40,NOW()),
       (11,1,10,NOW()),
       (11,5,50,NOW()),
       (11,7,70,NOW()),
       (11,9,90,NOW()),
       (11,8,80,NOW());

insert into public.transaction_history (investor_id,syndicate_id,transaction_amount,transaction_date)
values (9,1,10,NOW()),
       (9,3,30,NOW()),
       (9,5,50,NOW()),
       (9,4,40,NOW()),
       (9,7,70,NOW()),
       (9,9,90,NOW()),
       (9,8,80,NOW()),
       (9,10,100,NOW());

-- Your task is to identify and list the top 5 investors who have invested
-- in the highest number of unique syndicates, along with the total amount they have invested

select
  th.investor_id,
  COUNT(distinct th.syndicate_id) as unique_syndicate_count,
  SUM(th.transaction_amount) as total_investment_amount
from
  public.transaction_history th
group by
  th.investor_id
order by
  unique_syndicate_count desc,
  th.investor_id desc
  limit 5;
