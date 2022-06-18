insert into course(id,name,created_date,last_updated_date)
values(1001,'JPA in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id,name,created_date,last_updated_date)
values(1002,'Spring boot in 90 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id,name,created_date,last_updated_date)
values(1003,'Hibernate in 500 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into passport(id,number) values(4001,'AI 635897');
insert into passport(id,number) values(4002,'PV 365897');
insert into passport(id,number) values(4003,'LM 125963');

insert into student(id,name,passport_id) values(2001,'Mike Stoba',4001);
insert into student(id,name,passport_id) values(2002,'Alex Afanasiev',4002);
insert into student(id,name,passport_id) values(2003,'Lena Gerasymluik',4003);

insert into review(id,rating, description) values(5001,'5','Great Course');
insert into review(id,rating, description) values(5002,'5','Good job');
insert into review(id,rating, description) values(5003,'4','OK');