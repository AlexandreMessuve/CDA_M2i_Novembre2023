DELETE FROM Organization;

INSERT INTO Organization (id, name, address,number_of_employees, date_last_joined_or_left_employee)
VALUES
    (1, 'Organization 1', 'Address', 0, '2020-01-01 00:00:00'),
    (2, 'Organization 2', 'Address', 0, '2020-01-01 00:00:00'),
    (3, 'Organization 3', 'Address', 0, '2020-01-01 00:00:00'),
    (4, 'Organization 4', 'Address', 0, '2020-01-01 00:00:00'),
    (5, 'Organization 5', 'Address', 0, '2020-01-01 00:00:00');

ALTER TABLE Organization ALTER COLUMN id RESTART WITH 6;