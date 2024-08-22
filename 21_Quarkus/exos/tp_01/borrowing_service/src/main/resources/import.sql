-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into borrowing (start_date, end_date,book_id,user_id)
values
    ('2024-08-22','2024-08-24',1,1),
    ('2024-08-10','2024-08-15',1,2);