-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

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
(id, description, duedata, financetype, paymentdata, status, value)
VALUES
('a4bd40df-14a6-43ff-97ed-2433e8e78e74', 'Conta de Energia', '31-02-2022', 'Despesas', '15-01-2022', 'Pago', '280');

INSERT INTO public.finances_tb
(id, description, duedata, financetype, paymentdata, status, value)
VALUES
('c6f8b1d0-8f9f-11ec-82be-dfd8e4f9d15b', 'Conta de Internet', '20-03-2022', 'Despesas', '10-01-2022', 'Pago', '150');

INSERT INTO public.finances_tb
(id, description, duedata, financetype, paymentdata, status, value)
VALUES
('f5e730ac-8f9f-11ec-862d-4f03b7c947d2', 'Conta de Telefone', '25-04-2022', 'Receita', '20-01-2022', 'Pago', '500');