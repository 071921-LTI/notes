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

insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Goose, canada', 59473.18, 'Nurse', 'cbutlin0@shop-pro.jp', 'Ci5VBbCxajN', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Black-tailed deer', 57209.07, 'Nurse ', 'dpenswick1@omniture.com', 'jathFmUDCbL', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Toucan, white-throated', 58426.71, 'Cost', 'kdelboux2@technorati.com', 'zsIw862u5Da', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Pig-tailed macaque', 57229.33, 'Human', 'fkagan3@mail.ru', 'Z4ZZ21h', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Ring-tailed possum', 53545.13, 'Financial', 'bguilbert4@oaic.gov.au', 'jGbgjRNegvj', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Fowl, helmeted guinea', 55989.76, 'Budget I', 'kgratton5@ning.com', 'gKc0bg4X4', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Springbuck', 53052.99, 'Health Coach II', 'eissacson6@comcast.net', 'wBY1av', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Turkey, common', 50599.2, 'Environmental', 'lpales7@bravesites.com', 'VsPBQPY6b', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('American racer', 54606.84, 'Research', 'lshakesby8@harvard.edu', 'Dx3MrE5jW', 1);
insert into employees (empl_name, empl_salary, empl_role, empl_email, empl_pass, manager_id) values ('Galapagos penguin', 56111.23, 'Food Chemist', 'uvenn9@newyorker.com', 'ks5mgD', 1);

