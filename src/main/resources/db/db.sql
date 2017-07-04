-- Table: public.departments

-- DROP TABLE public.departments;

CREATE TABLE public.departments
(
  department_name CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  CONSTRAINT pk_department_name PRIMARY KEY (department_name)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.departments
  OWNER TO postgres;

-- Table: public.employees

-- DROP TABLE public.employees;

CREATE TABLE public.employees
(
  name       CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  surname    CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  birth_date DATE,
  salary     DOUBLE PRECISION                               NOT NULL,
  email      CHARACTER VARYING COLLATE pg_catalog."default" NOT NULL,
  department CHARACTER VARYING COLLATE pg_catalog."default",
  CONSTRAINT pk_email PRIMARY KEY (email),
  CONSTRAINT fk_department FOREIGN KEY (department)
  REFERENCES public.departments (department_name) MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE SET NULL
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employees
  OWNER TO postgres;

-- Index: fki_fk_department

-- DROP INDEX public.fki_fk_department;

CREATE INDEX fki_fk_department
ON public.employees USING BTREE
(department COLLATE pg_catalog."default")
TABLESPACE pg_default;