CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

-- 1. В одном запросе получить
-- имена всех person, которые не состоят в компании с id = 5;
-- название компании для каждого человека.
select p."name", c."name" 
from person p
join company c on c.id = p.company_id
where company_id != 5;

-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
select s."name", count from(
	select c."name", count(p.company_id)
	from company c
	join person p on p.company_id = c.id
	group by c."name", p.company_id
) as s
where s.count = (
	select count(p.company_id)
	from company c
	join person p on p.company_id = c.id
	group by p.company_id
	order by count desc limit 1
)
group by s.name, s.count;

-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании. - Одной строкой
select c."name", count(p.company_id)
from company c
join person p on p.company_id = c.id
group by c."name",p.company_id
order by count desc limit 1