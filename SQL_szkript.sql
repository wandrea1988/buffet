
--postgres db-be belépve egy új adatbázis létrehozása

create database buffet



--az új adatbázishoz csatlakozva az alábbi sql kéréseket kell lefutatni, a kiindulási adatok létrehozásához

create table if not exists employee (
	id serial primary key,
	employee_name varchar(100) not null
	);
    
create table if not exists product (
	id serial primary key,
    product_name varchar(50) not null,
    product_price int not null
);

create table if not exists sale (
    id serial primary key,
    employee_id int references employee (id),
    sale_time timestamp with time zone not null
);

create table if not exists sale_product (
	id serial primary key,
    product_id int references product (id),
    sale_id int references sale(id),
    quantity int not null
);

insert into employee (employee_name) values ('Gipsz Jakab');
insert into employee (employee_name) values ('Teszt Elek');
insert into employee (employee_name) values ('Kiss Pista');
insert into product (product_name, product_price) values ('kávé', 140);
insert into product (product_name, product_price) values ('szalámis szendo', 430);
insert into product (product_name, product_price) values ('hot-dog', 500);
insert into product (product_name, product_price) values ('virslis párna', 450);
insert into product (product_name, product_price) values ('üditő (0.5 l)', 230);
insert into product (product_name, product_price) values ('tea', 120);



