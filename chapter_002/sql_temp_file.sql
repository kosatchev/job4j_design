--создание таблицы
CREATE TABLE public.demo (
	name varchar NULL,
	passport int2 NOT NULL,
	birthdate timestamp(0) NULL,
	CONSTRAINT demo_pk PRIMARY KEY (passport)
);
CREATE INDEX demo_name_idx ON public.demo (name);

--добавление записи
INSERT INTO public.demo ("name",passport,birthdate)
	VALUES ('me',722,'4-06-1986')

--редактирование записи
UPDATE public.demo
	SET birthdate='1986-06-04 01:01:01',passport=777,"name"='new me'
	WHERE passport=722

--удаление записи
DELETE FROM public.demo
	WHERE passport=777
