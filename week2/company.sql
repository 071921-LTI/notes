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
	empl_salary NUMERIC(6,2),
	empl_role VARCHAR(20),
	empl_email VARCHAR(75) unique,
	empl_pass VARCHAR(50) not null check (length(empl_pass) > 7),
	manager_id INTEGER references employees(empl_id)
);

alter table employees 
	alter column empl_salary set data type numeric(7,2);
	-- add column something...
	-- drop column something;

create table if not exists tasks(
	task_id SERIAL primary key,
	task_name VARCHAR(30),
	task_description text,
	completion_status VARCHAR(10),
	assign_date DATE,
	due_date DATE,
	empl_id INTEGER references employees(empl_id)
);

insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass) values ('Goose, canada', 59473.18, 'Nurse', 'cbutlin0@shop-pro.jp', 'Ci5VBbCxajN');
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Black-tailed deer', 57209.07, 'Nurse ', 'dpenswick1@omniture.com', 'jathFmUDCbL', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Toucan, white-throated', 58426.71, 'Cost', 'kdelboux2@technorati.com', 'zsIw862u5Da', 1);
--insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Pig-tailed macaque', 57229.33, 'Human', 'fkagan3@mail.ru', 'Z4ZZ21h', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Ring-tailed possum', 53545.13, 'Financial', 'bguilbert4@oaic.gov.au', 'jGbgjRNegvj', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Fowl, helmeted guinea', 55989.76, 'Budget I', 'kgratton5@ning.com', 'gKc0bg4X4', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Springbuck', 53052.99, 'Health Coach II', 'eissacson6@comcast.net', 'wBY1av', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Turkey, common', 50599.2, 'Environmental', 'lpales7@bravesites.com', 'VsPBQPY6b', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('American racer', 54606.84, 'Research', 'lshakesby8@harvard.edu', 'Dx3MrE5jW', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Galapagos penguin', 56111.23, 'Food Chemist', 'uvenn9@newyorker.com', 'ks5mgD', 1);

select e.empl_name "Employee name", m.empl_name "Manager name"
from employees e
join employees m
on e.manager_id = m.empl_id;

select e.empl_id "e.empl_id",e.empl_name "e.empl_name", e.empl_salary "e.empl_salary", e.empl_role "e.empl_role", e.empl_email "e.empl_email", e.empl_pass "e.empl_pass", 
m.empl_name "m.empl_name", m.empl_salary "m.empl_salary", m.empl_role "m.empl_role", m.empl_email "m.empl_email", m.empl_pass "m.empl_pass", m.manager_id "m.manager_id"
from employees e
join employees m
on e.manager_id = m.empl_id;

select empl_id, upper(empl_name), length(empl_name) "length of name" from employees;

select avg(empl_salary) from employees;
select manager_id, avg(empl_salary) from employees group by manager_id;
select manager_id, avg(empl_salary) from employees 
	where length(empl_name) > 15
	group by manager_id 
	having manager_id > 0;