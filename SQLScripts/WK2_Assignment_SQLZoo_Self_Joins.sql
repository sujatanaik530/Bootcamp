-- SQL Zoo Self Joins

-- 1. How many stops are in the database.
select count(*)
from stops;

-- 2. Find the id value for the stop 'Craiglockhart'
select id from stops where name = 'Craiglockhart';

-- 3. Give the id and the name for the stops on the '4' 'LRT' service.
select s.id, s.name
from stops s join route r on s.id = r.stop
where r.num = '4'
and r.company = 'LRT';

-- 4. The query shown gives the number of routes that visit either London Road (149) or 
-- Craiglockhart (53). Run the query and notice the two services that link these stops have a count of 2. 
-- Add a HAVING clause to restrict the output to these two routes.
SELECT company, num, COUNT(*)
FROM route WHERE stop=149 OR stop=53
GROUP BY company, num
having COUNT(*) = 2;

