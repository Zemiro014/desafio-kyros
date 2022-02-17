-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO public.address_tb
(id, cep, city, "number", state, street)
VALUES('fb1921b1-3e34-45e9-b9d3-ab448589e378', '93110008', 'São Leopoldo', '1055', 'RS', 'Rua Osvaldo Aranha');

INSERT INTO public.address_tb
(id, cep, city, "number", state, street)
VALUES('405f00de-9012-11ec-baf2-c36f9a3e897f', '93010008', 'Porto Alegre', '1750', 'RS', 'Rua Santana');

INSERT INTO public.address_tb
(id, cep, city, "number", state, street)
VALUES('45deade8-9012-11ec-a0c6-a724ff393c9d', '93210008', 'Novo Hamburgo', '7015', 'RS', 'Rua Independência');

INSERT INTO public.provider_tb
(id, cnpjcpf, email, providername, providerphone, provider_address_id)
VALUES('8503b2ce-a378-4a38-a6fa-c7bc015f47f1', '70434586099', 'joao@gmail.com', 'João José', '5196587421', 'fb1921b1-3e34-45e9-b9d3-ab448589e378');

INSERT INTO public.provider_tb
(id, cnpjcpf, email, providername, providerphone, provider_address_id)
VALUES('d3947f1e-9012-11ec-a4c0-431b33ee1eb7', '04594619000122', 'kyros@gmail.com', 'Kyros', '5196587421', '405f00de-9012-11ec-baf2-c36f9a3e897f');

INSERT INTO public.provider_tb
(id, cnpjcpf, email, providername, providerphone, provider_address_id)
VALUES('559fc752-9013-11ec-9d14-7ba22ebf1f9b', '48633261000175', 'string03@gmail.com', 'Musikada', '5196857421', '45deade8-9012-11ec-a0c6-a724ff393c9d');