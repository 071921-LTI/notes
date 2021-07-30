explain analyze verbose select my_text from example1 where my_number > 500 and my_date > '2020-06-19';

explain analyze verbose select * from example1 where my_date = '2020-08-11';

-- table_name_colName(s)_typeidx
-- create or replace same_name
-- drop index index_name
create index example1_my_date_hashidx on example1 using hash (my_date);

explain analyze verbose select *
from example1 e 
join example2 e2
on (e.my_date = e2.my_date) 
join example3 e3 
on (e.my_number > e3.my_number) 
where e.my_number between 4000 and 6000 and e3.my_date = '2019-10-19';

create index example1_my_number_btreeidx on example1 (my_number);
create index example3_my_number_btreeidx on example3 (my_number);
create index example3_my_date_hashidx on example3 using hash (my_date);
create index example2_my_date_btreeidx on example2 using hash (my_date);

drop index example3_my_number_btreeidx;
drop index example3_my_date_hashidx;

create index example3_my_date_my_number_btree on example3 (my_number,my_date );

drop index example3_my_date_my_number_btree;

select count(e.*) from (select * from example1 e where my_date < '2020-08-11' ) e where e.my_number > 5000;
create view my_view as select * from example1 e where my_date < '2020-08-11';

select count(*) from my_view where my_number > 5000;