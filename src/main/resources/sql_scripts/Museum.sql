drop database museum_management;

create database if not exists museum_management;
use museum_management;

create table if not exists open_days (id int not null auto_increment primary key,
name varchar(10) not null);


create table if not exists museum (id int not null auto_increment primary key,
name varchar(45) not null,
capacity int not null,
open_time varchar(10) not null,
close_time varchar(10) not null);


create table if not exists museum_open_days (open_days_id int not null,
museum_id int not null,
CONSTRAINT PK_Museum_Days PRIMARY KEY (open_days_id, museum_id),
foreign key (open_days_id) references open_days(id),
foreign key (museum_id) references museum(id));


create table if not exists ticket_type (id int not null auto_increment primary key, 
name varchar(45) not null,
price double not null);


create table if not exists tour_schedule (id int not null auto_increment primary key,
start_date varchar(10) not null,
museum_id int not null,
foreign key (museum_id) references museum(id));

create table if not exists ticket (id int not null auto_increment primary key,
                                   ticket_type_id int not null,
                                   quantity int not null,
                                   foreign key (ticket_type_id) references ticket_type(id));

create table if not exists booking (id int not null auto_increment primary key,
ref varchar(45),
museum_id int not null,
customer_name varchar(45) not null,
tour_schedule_id int not null,
total_price int not null,
ticket_id int not null,
foreign key (museum_id) references museum(id),
foreign key (ticket_id) references ticket(id),
foreign key (tour_schedule_id) references tour_schedule(id));


