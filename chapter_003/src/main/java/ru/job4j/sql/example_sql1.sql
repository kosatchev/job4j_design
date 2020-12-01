--тип продуктов
CREATE sequence types_seq;
CREATE TABLE "types" (
	id int4 NOT NULL DEFAULT nextval('types_seq'),
	"name" varchar NOT NULL,
	CONSTRAINT types_pk PRIMARY KEY (id),
	CONSTRAINT types_un UNIQUE ("name")
);
--добавление типов
INSERT INTO public."types" ("name")	VALUES ('Сыр');
INSERT INTO public."types" ("name")	VALUES ('Мясо');
INSERT INTO public."types" ("name")	VALUES ('Молоко');
INSERT INTO public."types" ("name")	VALUES ('Фрукты');


--Продукты
CREATE sequence products_seq;
CREATE TABLE products (
	id int4 NOT NULL DEFAULT nextval('products_seq'),
	"name" varchar NOT NULL,
	type_id int4 NOT NULL,
	expired_date timestamp NOT NULL,
	price int4,
	quantity int4,
	CONSTRAINT products_pk PRIMARY KEY (id),
	CONSTRAINT products_un UNIQUE ("name"),
	CONSTRAINT products_fk_type_id FOREIGN KEY (type_id) REFERENCES "types"(id)
);
--Добавление продуктов
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Виноград',4,'2021-03-30',100,1);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Груши',4,'2021-03-20',60,2);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Бананы',4,'2021-03-10',50,3);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Тюменское',3,'2021-03-01',45,4);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Ситниково',3,'2021-02-20',40,5);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Индейка',2,'2021-02-20',300,6);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Яблоки',4,'2021-02-01',70,7);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('мороженное мясо птицы',2,'2021-01-30',350,8);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Говядина',2,'2021-01-20',400,9);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Курица',2,'2021-01-10',150,10);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Маасдам',2,'2021-01-01',130,11);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Гауда',2,'2020-12-30',120,12);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Голландский',2,'2020-12-20',110,13);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Российский',2,'2020-12-10',120,14);
INSERT INTO public.products ("name",type_id,expired_date,price,quantity) VALUES ('Пошехонский',2,'2020-12-01',100,15);


-- 1. Написать запрос получение всех продуктов с типом "Сыр"
select * from products
join "types" as t on type_id = t.id
where t."name" = 'Сыр';
-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from products where "name" like '%мороженное%';
-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from products where expired_date < now()+ interval '1 month';
-- 4. Написать запрос, который выводит самый дорогой продукт.
select * from products order by price desc limit 1;
-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
select t."name", count(t."name") from products
join "types" as t on type_id = t.id
group by t."name";
-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from products
join "types" as t on type_id = t.id
where t."name" = 'Сыр' or t."name" = 'Молоко';
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select t.name from products
join "types" as t on type_id = t.id
where quantity < 10
group by t.name;
-- 8. Вывести все продукты и их тип.
select p.name, t.name "type" from products p
join "types" as t on type_id = t.id;