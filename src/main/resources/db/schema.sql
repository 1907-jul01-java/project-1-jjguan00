drop table if exists reimbursements;
drop table if exists users;


create table users (
  id serial primary key,
  email text not null unique,
  name text not null unique,
  password text not null
);
create table reimbursements(
	id int primary key,
	context text not null,
	money int not null,
	status text not null,
	username text not null,
	constraint username foreign key(username) references Users(name) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO users(email,name,password) VALUES ('admin','admin','admin');
INSERT INTO users(email,name,password) VALUES ('jack','jack','jack');
INSERT INTO reimbursements(id,context,money,status,username) VALUES(23122, 'whatjknkbjkbk',  2000, 'pending','admin');
INSERT INTO reimbursements(id,context,money,status,username) VALUES(23222, 'what3333jknkbjkbk',  2000, 'pending','jack');