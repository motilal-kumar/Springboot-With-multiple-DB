delete from order_items;
delete from orders;

insert into orders(id, cust_name, cust_email) values(1,'Raja','raja@gmail.com');
insert into orders(id, cust_name, cust_email) values(2,'Mahima','mahima@gmail.com');
insert into orders(id, cust_name, cust_email) values(3,'Rashi','rashi@gmail.com');

insert into order_items(id, productcode,quantity,order_id) values(1,'S100', 2, 1);
insert into order_items(id, productcode,quantity,order_id) values(2,'S101', 1, 1);
insert into order_items(id, productcode,quantity,order_id) values(3,'S102', 5, 1);
insert into order_items(id, productcode,quantity,order_id) values(4,'S103', 2, 2);
insert into order_items(id, productcode,quantity,order_id) values(5,'S104', 1, 2);