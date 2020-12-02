-- Создать структур данных в базе.
-- Таблицы.
-- Кузов. Двигатель, Коробка передач.
-- Создать структуру Машина. Машина не может существовать без данных из п.1.
-- Заполнить таблицы через insert. 
-- Создать SQL запросы:
create table body(
id int2 not null,
name varchar not null,
	constraint body_pk primary key (id),
	constraint body_un unique (name)
);

create table engine(
id int2 not null,
name varchar not null,
	constraint engine_pk primary key (id),
	constraint engine_un unique (name)
);
create table transmission(
id int2 not null,
name varchar not null,
	constraint transmission_pk primary key (id),
	constraint transmission_un unique (name)
);

create table car(
id int2 not null,
name varchar not null,
body_id int2 not null,
engine_id int2 not null,
transmission_id int2 not null,
	constraint car_pk primary key (id),
	constraint car_un_body_id unique (body_id),
	constraint car_un_engine_id unique (engine_id),
	constraint car_un_transmission_id unique (transmission_id),
	constraint car_fk_body_id foreign key (body_id) references body(id),
	constraint car_fk_engine_id foreign key (engine_id) references engine(id),
	constraint car_fk_transmission_id foreign key (transmission_id) references transmission(id)
);

insert into body(id,name) values(1,'b1'),(2,'b2'),(3,'b3'),(4,'b4'),(5,'b5');
insert into engine(id,name) values(1,'e1'),(2,'e2'),(3,'e3'),(4,'e4'),(5,'e5');
insert into transmission(id,name) values(1,'t1'),(2,'t2'),(3,'t3'),(4,'t4'),(5,'t5');
insert into car(id,name,body_id,engine_id,transmission_id) values(1,'car1',1,1,1),(2,'car1',2,2,2),(3,'car1',3,3,3);

--1. Вывести список всехмашин и все привязанные к ним детали.
select c.name car, b.name body, e.name engine, t.name transmission from car c
join body b on c.body_id = b.id
join engine e on c.engine_id = e.id
join transmission t on c.transmission_id = t.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select b.name body, e.name engine, t.name transmission from car c
full join body b on c.body_id = b.id
full join engine e on c.engine_id = e.id
full join transmission t on c.transmission_id = t.id
where c.body_id is null and c.engine_id is null and c.transmission_id is null;