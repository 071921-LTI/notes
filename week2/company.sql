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


