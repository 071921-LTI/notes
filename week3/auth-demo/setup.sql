drop table if exists users;

create table if not exists users(
	id SERIAL primary key,
	username VARCHAR(50) unique not null,
	password VARCHAR(50) not null,
	role VARCHAR(50) not null
);


insert into users (username, role, password) values
	('Admin','Enrollment Admin', 'password'),
	('John', 'CEO', 'jathFmUDCbL'),
	('Jimmy', 'Manager',  'randomPass1');

