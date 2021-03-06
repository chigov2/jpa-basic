insert into course(id,name,created_date,last_updated_date,is_deleted)
values(1001,'JPA in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),false);

insert into course(id,name,created_date,last_updated_date,is_deleted)
values(1002,'Spring boot in 90 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),false);

insert into course(id,name,created_date,last_updated_date,is_deleted)
values(1003,'Hibernate in 500 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),false);

insert into course(id,name,created_date,last_updated_date,is_deleted)
values(1004,'JPA in 50 steps - test',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),false);

insert into passport(id,number) values(4001,'AI 631234');
insert into passport(id,number) values(4002,'PV 123497');
insert into passport(id,number) values(4003,'LM 125963');

insert into student(id,name,passport_id) values(2001,'Mike Stoba',4001);
insert into student(id,name,passport_id) values(2002,'Alex Afanasiev',4002);
insert into student(id,name,passport_id) values(2003,'Lena Gerasymluik',4003);

insert into review(id,rating, description,course_id) values(5001,'5','Great Course',1001);
insert into review(id,rating, description,course_id) values(5002,'5','Good job',1001);
insert into review(id,rating, description,course_id) values(5003,'4','Best Course!!',1003);

insert into student_course(student_id,course_id) values(2001,1001);
insert into student_course(student_id,course_id) values(2002,1001);
insert into student_course(student_id,course_id) values(2003,1001);
insert into student_course(student_id,course_id) values(2001,1003);
