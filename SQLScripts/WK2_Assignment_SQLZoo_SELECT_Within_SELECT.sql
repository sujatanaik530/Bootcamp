-- SQLZoo SELECT within SELECT

-- 1. List each country name where the population is larger than that of 'Russia'.
SELECT name FROM world
  WHERE population >
     (SELECT population FROM world
      WHERE name='Russia')
      
-- 2. Show the countries in Europe with a per capita GDP greater than 'United Kingdom'.
-- Per Capita GDP: The per capita GDP is the gdp/population
select name
from world
where gdp/population > (select gdp/population from world where name = 'United Kingdom')
and continent = 'Europe';

-- 3. List the name and continent of countries in the continents containing either Argentina or 
-- Australia. Order by name of the country.
select name, continent
from world
where continent in (select continent from world where name in ('Argentina', 'Australia'))
order by NAME;

-- 4. Which country has a population that is more than Canada but less than Poland? Show the name 
-- and the population.
select name, population
from world
where population < (select population from world where name = 'Poland')
and population > (select population from world where name = 'Canada');

-- 5. Show the name and the population of each country in Europe. Show the population as a percentage 
-- of the population of Germany.
-- Germany (population 80 million) has the largest population of the countries in Europe. Austria 
-- (population 8.5 million) has 11% of the population of Germany.
-- Show the name and the population of each country in Europe. Show the population as a percentage of 
-- the population of Germany.
-- The format should be Name, Percentage for example:
select NAME,
 concat(round(population*100/(select population from world where name = 'Germany')), '%') as percentage
from world
where continent = 'Europe';


-- 6. Which countries have a GDP greater than every country in Europe? [Give the name only.] (Some 
-- countries may have NULL gdp values)
select name
from world
where gdp is not null
and gdp > (select max(gdp) from world where continent = 'Europe');

-- 7. Find the largest country (by area) in each continent, show the continent, the name and the area:
SELECT continent, name, AREA 
FROM world x
WHERE area >= ALL (SELECT area FROM world y WHERE y.continent=x.continent);

-- or
SELECT continent, name, area FROM world x
WHERE area >= (SELECT max(area) FROM world y WHERE y.continent=x.continent);

-- 8. List each continent and the name of the country that comes first alphabetically.
select w1.continent, w1.name
from world w1
where w1.name = (select w2.name 
						from world w2 
						where w1.continent = w2.continent 
						order by w2.name 
						limit 1);

-- 9. Find the continents where all countries have a population <= 25000000. Then find the names of the 
-- countries associated with these continents. Show name, continent and population.
select w1.name, w1.continent, w1.population
from world w1
where 25000000 > all(select w2.population from world w2 where w1.continent = w2.continent);

-- 10. Some countries have populations more than three times that of all of their neighbours (in the 
-- same continent). Give the countries and continents.
-- Help! Give only one row instead of three.
select w1.name, w1.continent
from world w1
where w1.population > all (select 3 * sum(w2.population) 
                           from world w2 
                           where w1.continent = w2.continent
                           and w1.name != w2.name);
