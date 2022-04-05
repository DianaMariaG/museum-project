use museum_management;

insert into museum(name, capacity, open_time, close_time) values
('World Science Museum', 500, '09:00 AM', '06:00 PM');

insert into open_days (name) values ('TUESDAY'),('WEDNESDAY'),('THURSDAY'),('FRIDAY'),('SATURDAY'),('SUNDAY');

insert into museum_open_days (open_days_id, museum_id) values (1,1), (2,1), (3,1), (4,1), (5,1), (6,1);

insert into ticket_type(name, price) values
('ADULT', 40.0),
('CHILD', 15.0),
('STUDENT', 25.0),
('SENIOR', 25.0);

insert into tour_schedule (start_date, museum_id) values
('09:00 AM',1),
('10:00 AM',1),
('11:00 AM',1),
('12:00 PM',1),
('03:00 PM',1),
('04:00 PM',1),
('05:00 PM',1),
('06:00 PM',1);

