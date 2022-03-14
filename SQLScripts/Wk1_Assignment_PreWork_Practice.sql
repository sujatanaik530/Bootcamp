-- Week 1 assignment
-- SQL Pre-work Practice - Basic Select

-- Revising the select query I
SELECT *
FROM city
WHERE countrycode = 'USA'
AND population > 100000;

-- Revising the Select Query II 
SELECT name
FROM city
WHERE countrycode = 'USA'
AND population > 120000;

-- Japanese Cities' Attributes 
SELECT *
FROM city
WHERE countrycode = 'JPN';

-- Japanese Cities' Names 
SELECT name
FROM city
WHERE countrycode = 'JPN';

-- Select By ID 
SELECT *
FROM city
WHERE id = 1661;

-- Weather Observation Station 1 
SELECT city, state
FROM station;

-- Weather Observation Station 3 
SELECT DISTINCT city
FROM station
WHERE id%2 = 0;

-- Weather Observation Station 4 
select count(city) - count(distinct city)
from station;

-- Weather Observation Station 6 
SELECT DISTINCT city
FROM station
WHERE LEFT(city, 1) IN ('A', 'E', 'I', 'O', 'U');

-- Weather Observation Station 7 
SELECT DISTINCT city
FROM station
WHERE RIGHT(city, 1) IN ('A', 'E', 'I', 'O', 'U');

-- Weather Observation Station 8 
SELECT DISTINCT city
FROM station
WHERE LEFT(city, 1) IN ('A', 'E', 'I', 'O', 'U')
AND RIGHT(city, 1) IN ('A', 'E', 'I', 'O', 'U');

-- Weather Observation Station 9 
SELECT DISTINCT city
FROM station
WHERE NOT LEFT(city, 1) IN ('A', 'E', 'I', 'O', 'U');

-- Weather Observation Station 10 
SELECT DISTINCT city
FROM station
WHERE NOT RIGHT(city, 1) IN ('A', 'E', 'I', 'O', 'U');

-- Weather Observation Station 11 
SELECT DISTINCT city
FROM station
WHERE LEFT(city, 1) NOT IN ('A', 'E', 'I', 'O', 'U')
OR RIGHT(city, 1) NOT IN ('A', 'E', 'I', 'O', 'U');

-- Weather Observation Station 12
SELECT DISTINCT city
FROM station
WHERE NOT LEFT(city, 1) IN ('A', 'E', 'I', 'O', 'U')
AND NOT RIGHT(city, 1) IN ('A', 'E', 'I', 'O', 'U');
