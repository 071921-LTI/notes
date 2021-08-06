-- This is a single line comment

/*
	This
	is
	a
	multi
	line
	comment
	
	Naming convention is snake_case, due to the lack of case sensitivity
	keywords such as datatypes and constraints should be uppercased
*/

-- Creating a schema 
--create schema company;
--drop schema company;

drop table employees;
create table employees(
	empl_id SERIAL primary key,
	empl_name VARCHAR(50) not null,
	empl_salary NUMERIC(9,2),
	empl_role VARCHAR(20),
	empl_email VARCHAR(75) unique,
	empl_pass VARCHAR(50) not null,
	manager_id INTEGER references employees(empl_id) default 1
);

--alter table employees 
--	alter column empl_salary set data type numeric(7,2);
	-- add column something...
	-- drop column something;

drop table if exists tasks;

create table if not exists tasks(
	task_id SERIAL primary key,
	task_name VARCHAR(30),
	task_description text,
	completion_status VARCHAR(15),
	assign_date DATE default CURRENT_DATE,
	due_date DATE,
	empl_id INTEGER references employees(empl_id)
);

insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values
	('Enrollment Admin', 0, 'Enrollment Admin', 'enrollment_admin@company.com', 'password', 1),
	('John Doe', 1000000, 'CEO', 'john.doe@company.com', 'jathFmUDCbL', 2),
	('Jimmy Joe', 130000, 'Manager', 'jimmy.joe@company.com', 'randomPass1', 2),
	('Timmy Tom', 55000, 'Grunt', 'timmy.tom@company.com', 'TimPass1', 3),
	('Jackie Jack', 55000, 'Grunt', 'jackie.jack@company.com', 'JackiePass2', 3),
	('Newbie Newb', 1000, 'TBD', 'newbie.newb@company.com', 'NewbiePass3', 1);
	
insert into tasks (task_name, task_description, completion_status, due_date, empl_id) values
	('Urgent task', 'Something very urgent, please fix.', 'IN_PROGRESS', '2022-8-15', 4),
	('Mundane task', 'Something that is pretty useless, really.', 'IN_PROGRESS', '2021-10-15', 4),
	('Is this a task', 'Something that is questionable, at best.', 'IN_PROGRESS', '2021-11-15', 3),
	('Manager task', 'Managers gotta keep busy', 'IN_PROGRESS', '2021-12-15', 3),
	('New task', 'Something that is new.', 'NEW', '2022-1-01', null);

select e.empl_name "Employee name", m.empl_name "Manager name"
from employees e
join employees m
on e.manager_id = m.empl_id;

select * from tasks;

select e.empl_id "e.empl_id",e.empl_name "e.empl_name", e.empl_salary "e.empl_salary", e.empl_role "e.empl_role", e.empl_email "e.empl_email", e.empl_pass "e.empl_pass", 
m.empl_name "m.empl_name", m.empl_salary "m.empl_salary", m.empl_role "m.empl_role", m.empl_email "m.empl_email", m.empl_pass "m.empl_pass", m.manager_id "m.manager_id"
from employees e
join employees m
on e.manager_id = m.empl_id;

select * 
from tasks t
join employees e 
on t.empl_id =e.empl_id;

select empl_id, upper(empl_name), length(empl_name) "length of name" from employees;

select avg(empl_salary) from employees;
select manager_id, avg(empl_salary) from employees group by manager_id;
select manager_id, avg(empl_salary) from employees 
	where length(empl_name) > 15
	group by manager_id 
	having manager_id > 0;
	
select * from employees where length(empl_role)>4
union 
select * from employees where empl_salary > 57000;

select * from employees where length(empl_role)>4
union all
select * from employees where empl_salary > 57000;

select * from employees where length(empl_role)>4
intersect
select * from employees where empl_salary > 57300;

select * from employees where length(empl_role)>4
except
select * from employees where empl_salary > 57300;

explain analyze verbose select * from employees;
