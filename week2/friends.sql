create database example_many_to_many;
drop database example_many_to_many;

create table if not exists users(
	id SERIAL primary key,
	first_name VARCHAR(20),
	last_name VARCHAR(20)
);

create table friends(
	friend1 INTEGER references users(id),
	friend2 INTEGER references users(id),
	primary key(friend1, friend2)
);

insert into users(first_name, last_name) values('Kevin', 'Tran Huu');
insert into users(first_name, last_name) values('Jimmy', 'John');
insert into users(first_name, last_name) values
	('Sally', 'Sal'),
	('Kenny', 'Ken');
	
insert into users (first_name, last_name) values ('Anatollo', 'Tennant');
insert into users (first_name, last_name) values ('Seymour', 'Cullon');
insert into users (first_name, last_name) values ('Garnet', 'Rivelon');
insert into users (first_name, last_name) values ('Tobey', 'O''Lahy');
insert into users (first_name, last_name) values ('Fredia', 'Cownden');
insert into users (first_name, last_name) values ('Cesare', 'Rosendahl');
insert into users (first_name, last_name) values ('Marrilee', 'Kleinholz');
insert into users (first_name, last_name) values ('Netty', 'Grzelewski');
insert into users (first_name, last_name) values ('Lynnette', 'Menchenton');
insert into users (first_name, last_name) values ('Adina', 'Swansbury');
insert into users (first_name, last_name) values ('Marylinda', 'Ralphs');
insert into users (first_name, last_name) values ('Ibby', 'Kell');
insert into users (first_name, last_name) values ('Yoshi', 'Currell');
insert into users (first_name, last_name) values ('Melissa', 'Pethybridge');
insert into users (first_name, last_name) values ('Christine', 'Dungate');
insert into users (first_name, last_name) values ('Elly', 'Carlone');
insert into users (first_name, last_name) values ('Rab', 'Squibbes');
insert into users (first_name, last_name) values ('Neron', 'Hully');
insert into users (first_name, last_name) values ('Pate', 'Josovich');
insert into users (first_name, last_name) values ('Ermengarde', 'McIlmorow');

--update users set last_name = 'James' where id = 5;
--update users set last_name = 'James';

--delete from users where first_name = 'Netty';
delete from users;

--truncate table users;

select * from users;

select first_name, last_name from users;

select first_name, last_name from users where id > 35 and length(last_name) < 5 order by first_name asc;

insert into friends (friend1, friend2) values (26, 35), (32,33), (26, 27);