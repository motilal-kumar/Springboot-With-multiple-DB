delete from addresses;
delete from users;

insert into users(id, name, email,disabled) values(1,'Raja','raja@gmail.com', false);
insert into users(id, name, email,disabled) values(2,'Rohan','rohan@gmail.com', false);
insert into users(id, name, email,disabled) values(3,'Anuj','anuj@gmail.com', true);

insert into addresses(id,city,user_id) values(1, 'Bangalore',1);
insert into addresses(id,city,user_id) values(2, 'Patna',1);
insert into addresses(id,city,user_id) values(3, 'Bihar',2);
insert into addresses(id,city,user_id) values(4, 'Mumbai',3);
insert into addresses(id,city,user_id) values(5, 'Delhi',3);
insert into addresses(id,city,user_id) values(6, 'Punjab',3);