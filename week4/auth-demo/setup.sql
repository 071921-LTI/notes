drop table if exists pokemons;
drop table if exists users;

create table if not exists users(
	id SERIAL primary key,
	username VARCHAR(50) unique not null,
	password VARCHAR(50) not null,
	role VARCHAR(50) not null
);

create table if not exists pokemons(
	id SERIAL primary key,
	nickname varchar(20) not null,
	poke_id integer not null,
	user_id integer references users(id)
);

insert into users (username, role, password) values
	('Admin','Enrollment Admin', 'password'),
	('John', 'CEO', 'jathFmUDCbL'),
	('Jimmy', 'Manager',  'randomPass1');

insert into pokemons (nickname, poke_id, user_id) values
	('Bulby', 1, 1),
	('Ivy', 2, 3);
