drop table if exists checkusers;
drop table if exists users;
drop table if exists reimbursements;
drop table if exists checks;
drop table if exists admins;

create table users (
  id serial primary key,
  email text not null unique,
  name text not null,
  password text not null
);
create table reimbursements(
	id serial primary key,
	context text not null,
	money int not null,
	status text not null,
	username text not null,
	constraint username foreign key(username) references users(name) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO users(email,name,password) VALUES ('admin','admin','admin');