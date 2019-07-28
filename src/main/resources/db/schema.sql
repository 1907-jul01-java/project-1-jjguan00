drop table if exists checkusers;
drop table if exists users;
drop table if exists transactions;
drop table if exists checks;
drop table if exists admins;

create table users (
  id serial primary key,
  username text not null unique,
  firstname text not null,
  password text not null
);
create table admins(
	id serial primary key,
	adminname text not null,
	password text not null
);

INSERT INTO admins(adminname,password) VALUES ('admin','admin');