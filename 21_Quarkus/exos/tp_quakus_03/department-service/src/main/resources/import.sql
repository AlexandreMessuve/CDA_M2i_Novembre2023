DELETE FROM Department;

INSERT INTO Department (id, name, organization_id)
VALUES
    (1, 'IT', null),
    (2, 'HR', 4),
    (3, 'Finance', 5),
    (4, 'Marketing', 1),
    (5, 'Sales', null);

ALTER TABLE Department ALTER COLUMN id RESTART WITH 6;

