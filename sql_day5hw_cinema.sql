#1. Show film which dont have any screening
SELECT distinct name 
FROM film f left join screening s
ON  s.film_id = f.id
WHERE s.id is null;

#2. Who book more than 1 seat in 1 booking
SELECT r.booking_id, c.first_name, c.last_name
FROM reserved_seat r join booking b join customer c
ON b.id = r.booking_id AND b.customer_id = c.id
GROUP BY booking_id
having count(booking_id)>1;

#3. Show room show more than 2 film in one day 
SELECT DISTINCT r.name     
FROM screening s
JOIN room r ON s.room_id = r.id
GROUP BY DATE(s.start_time), r.id
HAVING COUNT(film_id) > 2; 

#4. which room show the least film ? 
WITH leastFilm AS (SELECT COUNT(DISTINCT film_id) numberOfFilm, r.name
                  FROM room r JOIN screening s
                  ON r.id = s.room_id
				  GROUP BY r.id )
SELECT name, numberOfFilm
FROM leastFilm
WHERE numberOfFilm = (SELECT MIN(numberOfFilm)
						FROM leastFilm);
#5.what film don't have booking 
SELECT f.name
FROM booking b
JOIN screening s
RIGHT JOIN film f ON  b.screening_id = s.id AND s.film_id = f.id 
WHERE b.id IS NULL;

#6. WHAT film have show the biggest number of room?
WITH mostRoom AS (SELECT COUNT(DISTINCT(s.room_id)) as numberOfRoom, f.name
                  FROM screening s
				  JOIN film f ON s.film_id = f.id
                  GROUP BY f.id)
SELECT name, numberOfRoom
FROM mostRoom
WHERE numberOfRoom = ( SELECT MAX(numberOfRoom) 
                         FROM mostRoom);

#7. Show number of film  that show in every day of week and order descending
SELECT COUNT(distinct film_id), Date(start_time)
FROM screening
group by DATE(start_time)
order by  COUNT(distinct film_id) DESC;

#8. show total length of each film that showed in 28/5/2022
SELECT f.name, sum(length_min) 
FROM screening s join film f 
ON s.film_id = f.id
WHERE DATE(start_time) = '2022-05-28'
GROUP BY name;

#9. What film has showing time above and below average show time of all film
#9.1 Showing time above average showtime of all film
SELECT *
FROM film
WHERE length_min > (SELECT AVG(length_min) FROM film); 
#9.2 Showing time below average showtime of all film
SELECT *
FROM film
WHERE length_min < (SELECT AVG(length_min) FROM film); 

#10. what room have least number of seat?
with minSeat as (SELECT name,  count(s.id) numberOfSeat
					FROM room r join seat s
					WHERE r.id = s.room_id
					group by r.name)
SELECT name, numberOfSeat
FROM minSeat
WHERE numberOfSeat = (SELECT MIN(numberOfSeat)
                        FROM minSeat);
                        
#11. what room have number of seat bigger than average number of seat of all rooms
WITH seatInRoom AS (SELECT COUNT(*) numberOfSeat, r.name
                    FROM room r
                    JOIN seat s ON r.id = s.room_id
                    GROUP BY r.id)
SELECT name, numberOfSeat
FROM seatInRoom
WHERE numberOfSeat > (SELECT AVG(numberOfSeat)
                        FROM seatInRoom);
                        
#12 Ngoai nhung seat mà Ong Dung booking duoc o booking id = 1 thi ong CÓ THỂ (CAN) booking duoc nhung seat nao khac khong?

#13.Show Film with total screening and order by total screening. BUT ONLY SHOW DATA OF FILM WITH TOTAL SCREENING > 10
SELECT f.name, count(*) totalScreening
FROM film f join screening s 
ON s.film_id = f.id 
group by f.name
having totalScreening > 10
order by totalScreening ;

#14.TOP 3 DAY OF WEEK based on total booking

#15.CALCULATE BOOKING rate over screening of each film ORDER BY RATES.
SELECT (COUNT(b.id)/COUNT(s.id))*100 rate, f.name
FROM booking b
RIGHT JOIN screening s ON s.id = b.screening_id
RIGHT JOIN film f ON s.film_id = f.id
GROUP BY f.id
ORDER BY rate;

#16.CONTINUE Q15 -> WHICH film has rate over average ?.
WITH filmRate AS (SELECT (COUNT(b.id)/COUNT(s.id))*100 rate, f.name
				FROM booking b
				RIGHT JOIN screening s ON s.id = b.screening_id
				RIGHT JOIN film f ON s.film_id = f.id
				GROUP BY f.id)
SELECT name,rate
FROM filmRate
WHERE rate > (SELECT AVG(rate)
              FROM filmRate);

#17.TOP 2 people who enjoy the least TIME (in minutes) in the cinema based on booking info - only count who has booking info (example : Dũng book film tom&jerry 4 times -> Dũng enjoy 90 mins x 4)