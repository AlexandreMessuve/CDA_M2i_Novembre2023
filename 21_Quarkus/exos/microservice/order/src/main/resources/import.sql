-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into orders (quantity,orderDate,product_id,client_id)
values
    (3,'2024-08-21',1,2),
    (1,'2024-08-21',2,1),
    (5,'2024-08-21',4,4),
    (1,'2024-08-21',3,3),
    (7,'2024-08-21',3,4),
    (2,'2024-08-21',1,1);