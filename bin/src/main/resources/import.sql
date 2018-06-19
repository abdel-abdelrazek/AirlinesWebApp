insert into airport (id,airportcode,city,country,name) values (4,'AMS','Amsterdam','The Netherlands','Schiphol');
insert into airport (id,airportcode,city,country,name) values (5,'DTW','Detroid','USA','Detroid City');
insert into airport (id,airportcode,city,country,name) values (8,'NRT','Tokyo','Japan','Narita International Airport');
insert into airport (id,airportcode,city,country,name) values (12,'SYD','Sydney','Australia','Kingsford Smith');
insert into airport (id,airportcode,city,country,name) values (13,'LAX','Los Angeles','USA','Los Angeles International');
insert into airport (id,airportcode,city,country,name) values (19,'FRA','Frankfurt','Germany','Frankfurt International Airport');
insert into airport (id,airportcode,city,country,name) values (20,'ORD','Chicago','USA','Chicago O''hare International');
insert into airport (id,airportcode,city,country,name) values (23,'LHR','London','UK','London Heathrow');
insert into airport (id,airportcode,city,country,name) values (27,'JFK','New York','USA','John F. Kennedy International');
insert into airport (id,airportcode,city,country,name) values (29,'SIN','Singapore','Singapore','Changi Airport');

insert into airline (id, name) values (2,'SkyTeam');
insert into airline (id, name) values (10,'oneworld');
insert into airline (id, name) values (17,'North Star');

insert into airplane (id,capacity,model,serialnr) values (3,519,'A380','12345');
insert into airplane (id,capacity,model,serialnr) values (7,416,'747','54321');
insert into airplane (id,capacity,model,serialnr) values (11,519,'A380','23451');
insert into airplane (id,capacity,model,serialnr) values (15,416,'747','43215');
insert into airplane (id,capacity,model,serialnr) values (18,519,'A380','34512');
insert into airplane (id,capacity,model,serialnr) values (22,416,'747','32154');

insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (1,'2015-06-25','09:00:00','2009-08-06','19:10:00','NW 36',2,3,4,5);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (6,'2015-06-25','13:45:00','2009-08-06','15:05:00','NW 96',2,7,5,8);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (9,'2015-06-25','06:15:00','2009-08-05','22:30:00','QF 12',10,11,12,13);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (14,'2015-06-25','06:55:00','2009-08-06','21:55:00','QF 21',10,15,8,12);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (16,'2015-06-25','05:45:00','2009-08-06','14:30:00','UA 944',17,18,19,20);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (21,'2015-06-25','07:30:00','2009-08-06','12:59:00','UA 934',17,22,23,13);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (24,'2015-06-25','07:40:00','2015-06-25','07:15:00','NW 8445',2,3,23,4);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (25,'2015-06-25','12:21:00','2015-06-25','12:05:00','NW 1689',2,7,20,5);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (26,'2015-06-25','23:39:00','2015-06-25','15:00:00','QF 3101',10,11,27,13);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (28,'2015-06-25','17:15:00','2015-06-25','11:05:00','QF 4022',10,15,29,8);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (30,'2015-06-25','14:53:00','2015-06-25','12:45:00','UA 941',17,18,20,19);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (31,'2015-06-25','10:38:00','2015-06-25','08:10:00','UA 4842',17,22,4,23);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (32,'2009-08-07','10:38:00','2009-08-07','08:10:00','UA 4842',17,22,4,23);

-- MySQL/Oracle
--UPDATE hibernate_sequence SET next_val = 1000;

--Derby
UPDATE APP."SEQUENCE" SET SEQ_COUNT=1000 WHERE SEQ_NAME='SEQ_GEN';




