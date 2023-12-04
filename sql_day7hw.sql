#Write an SQL query that counts the total number of tickets reserved for each play. 
#The table of results should contain three columns: id (id of play), title (title of play) and reserved_tickets (total number of reserved tickets for play). 
#Rows should be ordered by decreasing reserved tickets. In the case of a tie, rows should be sorted by increasing id of play.

SELECT r.play_id, p.title, sum(number_of_tickets) as reserved_ticket
FROM reservations r JOIN plays p ON r.play_id = p.id
GROUP BY play_id
ORDER BY reserved_ticket DESC, play_id;

#The value of money can be positive or negative: 
#a positive value indicates a deposit whilst a negative value represents a withdrawal. 
#Write an SQL query that for every name finds the sum of all deposits and the sum of all withdrawals. 
#Return a three-column table containing: name, sum_of_deposits, sum_of_withdrawals. The names in the returned table should appear in alphabetical order. 

SELECT name, SUM(IF(money < 0 , 0 , money)) AS sum_of_deposits, SUM(IF(money > 0 , 0 , money))*(-1) AS sum_of_withdrawals
FROM transfers t
GROUP BY name
ORDER BY name;

#Each row of table buses contains information about a single bus's origin (origin), destination (destination) and time of departure (time). 
#Each row of table passengers describes a single passenger and contains information about the station they're traveling from (origin), 
#the station they're traveling to (destination) and the time they will arrive at the departure station (time).
#Passengers will board the earliest possible bus that travels directly to their desired destination. 
#Passengers can still board a bus if it departs in the same minute that they arrive at the station. 
#All passengers who are still at the station at 23:59 and don't board any of the 23:59 buses will leave the platform without boarding any bus.
#You can assume that no two buses with the same origin and destination depart at the same time.
#Write an SQL query that, for each bus, returns the number of passengers boarding it. 
#For each bus you should provide its id (id) and the number of passengers on board (passengers_on_board). Rows should be ordered by the id column (in ascending order).
#Time is represented as a string in the format HH:MM.