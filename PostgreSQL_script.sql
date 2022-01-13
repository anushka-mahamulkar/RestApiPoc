
drop TABLE employee;

CREATE TABLE employee (
	ID numeric  PRIMARY KEY,
	FIRST_NAME text NOT NULL,
	LAST_NAME text NOT NULL,
	SALARY numeric
);

insert into employee values (100, 'Vinod', 'Patne', 909);

select * from employee;

