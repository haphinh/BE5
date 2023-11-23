#Show film name ONLY which has screening.
SELECT name
FROM cinema.screening join cinema.film  ON cinema.film.id = cinema.screening.film_id
GROUP BY name;

#Show Room name with all seat row and seat column of "Room 2"
SELECT name, cinema.seat.row, cinema.seat.number
FROM cinema.room join cinema.seat  ON cinema.room.id = cinema.seat.room_id
WHERE cinema.room.name ='Room 2';

#Show all Screening Infomation including film name, room name, time of film "Tom&Jerry"
SELECT cinema.film.name, cinema.room.name, 	cinema.screening.start_time
FROM cinema.film join cinema.screening  join cinema.room 
ON cinema.film.id = cinema.screening.film_id AND cinema.screening.room_id = room.id
WHERE cinema.film.name = 'Tom&Jerry';

#Show what seat that customer "Dung Nguyen" booked
SELECT cinema.customer.first_name, cinema.customer.last_name, cinema.seat.row, cinema.seat.number
FROM cinema.customer join cinema.booking  join cinema.reserved_seat join cinema.seat 
ON cinema.customer.id = cinema.booking.customer_id 
AND cinema.booking.id = cinema.reserved_seat.booking_id 
AND cinema.reserved_seat.seat_id = cinema.seat.id
WHERE cinema.customer.first_name = 'Dung' AND cinema.customer.last_name = 'Nguyen';

#How many film that showed in 24/5/2022screening
SELECT count(start_time)
FROM cinema.screening
WHERE cinema.screening.start_time BETWEEN '2022-05-24 00:00:00' AND '2022-05-24 23:59:59';

#What is the maximum length and minumum length of all film
SELECT MIN(length_min), MAX(length_min)
FROM cinema.film;

#How many seat of Room 7
SELECT count(cinema.seat.id)
FROM cinema.room join cinema.seat  
ON cinema.room.id = cinema.seat.room_id
WHERE cinema.room.name = 'Room 7';

#Total seat are booked of film "Tom&Jerry"
SELECT count(seat_id)
FROM cinema.booking join cinema.screening join cinema.reserved_seat  join cinema.film
ON cinema.booking.screening_id = cinema.screening.id
AND cinema.screening.film_id = cinema.film.id
AND cinema.booking.id = cinema.reserved_seat.booking_id
WHERE cinema.film.name = 'Tom&Jerry';