# TestWebApp
RESTful CRUD Web App
1. Создать базу данных в PostgreSQL
CREATE TABLE public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    email text COLLATE pg_catalog."default" NOT NULL,
    phone_number text COLLATE pg_catalog."default",
    status text COLLATE pg_catalog."default",
    "time" time without time zone,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

2. Скачать проект, настроить application.properties.
3. Для удобства запускать TestProjApplication из idea.
4. Перейти по адресу http://localhost:8080/api/users. Рекомендуется использовать приложение Postman.
