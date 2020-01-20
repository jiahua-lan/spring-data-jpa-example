insert into department(id,name) values (1,'D_1');

insert into department(id,name) values (2,'D_2');

insert into department(id,name) values (3,'D_3');

insert into employee(id,name) values (4,'Tom');

insert into employee(id,name) values (5,'Jerry');

insert into employee_departments(employees_id,departments_id) values (4,1);

insert into employee_departments(employees_id,departments_id) values (5,2);

alter sequence hibernate_sequence restart with 6;