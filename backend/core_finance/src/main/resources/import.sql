-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

-- public.finace_category_tb definition
-- Drop table
-- DROP TABLE public.finace_category_tb;

--CREATE TABLE public.finace_category_tb (
--	id varchar(255) NOT NULL,
--	category varchar(255) NULL,
--	CONSTRAINT finace_category_tb_pkey PRIMARY KEY (id)
--);
INSERT INTO public.finace_category_tb (id, category) VALUES('898eb6de-93cb-11ec-90d3-4b3312e0064d', 'Veículo');
INSERT INTO public.finace_category_tb (id, category) VALUES('ac13f034-93cb-11ec-aa08-bf82d5395b7d', 'Casa');
INSERT INTO public.finace_category_tb (id, category) VALUES('03829942-93cc-11ec-8c37-9b8d38e3f462', 'Estudos');
-- This part will creating finance_tb TABLE
--CREATE TABLE public.finances_tb (
--	id varchar(255) NOT NULL,
--	description varchar(255) NULL,
--	duedata varchar(255) NULL,
--	financetype varchar(255) NULL,
--	paymentdata varchar(255) NULL,
--	status varchar(255) NULL,
--	value varchar(255) NULL
--);
INSERT INTO public.finances_tb
(id, description, duedata, financetype, paymentdata, status, value, category_id)
VALUES
('a4bd40df-14a6-43ff-97ed-2433e8e78e74', 'Conta de Energia', '31-02-2022', 'Despesa', '15-01-2022', 'Pago', '280', 'ac13f034-93cb-11ec-aa08-bf82d5395b7d');

INSERT INTO public.finances_tb
(id, description, duedata, financetype, paymentdata, status, value, category_id)
VALUES
('c6f8b1d0-8f9f-11ec-82be-dfd8e4f9d15b', 'Conta de Internet', '20-03-2022', 'Despesa', '10-01-2022', 'Pago', '150', 'ac13f034-93cb-11ec-aa08-bf82d5395b7d');

INSERT INTO public.finances_tb
(id, description, duedata, financetype, paymentdata, status, value, category_id)
VALUES
('f5e730ac-8f9f-11ec-862d-4f03b7c947d2', 'Conta de Telefone', '25-04-2022', 'Receita', '20-01-2022', 'Pago', '500', 'ac13f034-93cb-11ec-aa08-bf82d5395b7d');