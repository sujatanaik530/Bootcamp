-- SQLZoo More JOINs

-- 1. List the films where the yr is 1962 [Show id, title]
SELECT id, title
 FROM movie
 WHERE yr=1962;
 
-- 2. Give year of 'Citizen Kane'.
select yr
from movie
where title = 'Citizen Kane';

-- 3. List all of the Star Trek movies, include the id, title and yr (all of these movies include the
-- words Star Trek in the title). Order results by year.
select id, title, yr
from movie
where title like '%star trek%'
order by yr;

-- 4. What id number does the actor 'Glenn Close' have?
select id
from actor
where name = 'Glenn Close';

-- 5. What is the id of the film 'Casablanca'
select id
from  movie
where title = 'Casablanca';

-- Get to the point
-- 6. Obtain the cast list for 'Casablanca'.
-- what is a cast list? The cast list is the names of the actors who were in the movie.
-- Use movieid=11768, (or whatever value you got from the previous question)
select a.name
from actor a join casting c on a.id = c.actorid
where c.movieid = 11768;

-- 7. Obtain the cast list for the film 'Alien'
select a.name
from actor a join casting c on a.id = c.actorid
join movie m on m.id = c.movieid
where m.title = 'Alien';

-- 8. List the films in which 'Harrison Ford' has appeared
select m.title
from actor a join casting c on a.id = c.actorid
join movie m on m.id = c.movieid
where a.name = 'Harrison Ford';

-- 9. List the films where 'Harrison Ford' has appeared - but not in the starring role. [Note: the 
-- ord field of casting gives the position of the actor. If ord=1 then this actor is in the starring 
-- role]
select m.title
from actor a join casting c on a.id = c.actorid
join movie m on m.id = c.movieid
where a.name = 'Harrison Ford'
and c.ord != 1;

-- 10. List the films together with the leading star for all 1962 films.
select m.title, a.name
from movie m join casting c on m.id = c.movieid join actor a on c.actorid = a.id
where m.yr = 1962
and c.ord = 1;

-- Harder Questions

-- 11. Which were the busiest years for 'Rock Hudson', show the year and the number of movies he made
-- each year for any year in which he made more than 2 movies.
SELECT yr,COUNT(title) FROM
  movie JOIN casting ON movie.id=movieid
        JOIN actor   ON actorid=actor.id
WHERE name='Rock Hudson'
GROUP BY yr
HAVING COUNT(title) > 2;

-- 12. List the film title and the leading actor for all of the films 'Julie Andrews' played in.
-- Did you get "Little Miss Marker twice"? Julie Andrews starred in the 1980 remake of 
-- Little Miss Marker and not the original(1934).
-- Title is not a unique field, create a table of IDs in your subquery
select m.title, a1.name
from movie m join casting c1 on m.id = c1.movieid 
             join actor a1 on a1.id = c1.actorid
where m.id in
(select c.movieid
from casting c join actor a on c.actorid = a.id
where a.name = 'Julie Andrews')
and c1.ord = 1;

-- 13. Obtain a list, in alphabetical order, of actors who've had at least 15 starring roles.
-- Try it - lost connection to SQL server
select a.name
from actor a join casting c on a.id = c.actorid
where c.ord > 1
group by a.id, a.name
having count(c.movieid) >= 15
order by a.name;

-- 14. List the films released in the year 1978 ordered by the number of actors in the cast, 
-- then by title.
select m.title, count(c.actorid)
from movie m join casting c on m.id = c.movieid
where m.yr = 1978
group by m.id, m.title
order by count(c.actorid) desc, m.title ASC;

-- 15. List all the people who have worked with 'Art Garfunkel'.
select a1.name
from actor a1 join casting c1 on a1.id = c1.actorid
and c1.movieid in
(select c.movieid
from casting c join actor a on c.actorid = a.id
where a.name = 'Art Garfunkel')
and a1.name != 'Art Garfunkel';