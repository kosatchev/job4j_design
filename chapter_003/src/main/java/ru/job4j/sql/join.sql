-- 1 Создать таблицы и заполнить их начальными данными
create table departments (
id serial primary key,
"name" varchar

);

create table employee (
id serial primary key,
"name" varchar,
dep_id int references departments(id)
);

insert into departments(id,"name") values(1,'Alpga'),(2,'Beta'),(3,'Gamma');
insert into employee(id,"name",dep_id) values(1,'Max',null),(2,'Sam',1),(3,'Bart',2),(4,'Mary',3),(5,'Alice',2),(6,'Alex',null),(7,'Bob',null);

-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select * from employee e
join departments d on e.dep_id = d.id;

select * from employee e
left join departments d on e.dep_id = d.id;

select * from employee e
right join departments d on e.dep_id = d.id;

select * from employee e
full join departments d on e.dep_id = d.id;

select * from employee e
cross join departments d;

-- 3. Используя left join найти работников, которые не относятся ни к одну из департаментов
select * from employee e
left join departments d on e.dep_id = d.id
where dep_id is null;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат. 
select * from employee e
left join departments d on e.dep_id = d.id
where dep_id is not null;

select * from employee e
right join departments d on e.dep_id = d.id;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens (
name varchar,
gender boolean
);

insert into teens(name, gender) values
('Samuel',true),
('Thomas',true),
('Daniel',true),
('Samantha',false),
('Tammy',false),
('Denise',false);

select * from teens t1
cross join teens t2
where t1.gender = true and t2.gender = false;