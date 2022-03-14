-- SQL Zoo JOINs

-- 1. show the matchid and player name for all goals scored by Germany. To identify German players, 
-- check for: teamid = 'GER'
SELECT matchid , player  FROM goal 
  WHERE teamid = 'GER';
  
-- 2. Show id, stadium, team1, team2 for just game 1012
SELECT id,stadium,team1,team2
  FROM game
where id = 1012;

-- 3. show the player, teamid, stadium and mdate for every German goal
SELECT player, teamid, stadium, mdate
  FROM game JOIN goal ON (id=matchid)
where teamid = 'GER';

-- 4. Show the team1, team2 and player for every goal scored by a player called Mario player LIKE 
-- 'Mario%'
SELECT team1, team2, player
  FROM game JOIN goal ON (id=matchid)
where player like 'Mario%';

-- 5. The table eteam gives details of every national team including the coach. You can JOIN goal 
-- to eteam using the phrase goal JOIN eteam on teamid=id
-- Show player, teamid, coach, gtime for all goals scored in the first 10 minutes gtime<=10
SELECT player, teamid, coach, gtime
  FROM goal join eteam on (teamid=id)
 WHERE gtime<=10;
 
-- 6. To JOIN game with eteam you could use either game JOIN eteam ON (team1=eteam.id) or game JOIN
-- eteam ON (team2=eteam.id)
-- Notice that because id is a column name in both game and eteam you must specify eteam.id instead 
-- of just id
-- List the dates of the matches and the name of the team in which 'Fernando Santos' was the team1 
-- coach.
select g.mdate, t.teamname
from game g join eteam t on g.team1 = t.id
where t.coach = 'Fernando Santos'

-- 7. List the player for every goal scored in a game where the stadium was 'National Stadium, Warsaw'
select gl.player
from goal gl join game gm on (gl.matchid = gm.id)
where gm.stadium = 'National Stadium, Warsaw';

-- 8. show the name of all players who scored a goal against Germany.
SELECT distinct player
  FROM game JOIN goal ON matchid = id 
    WHERE teamid != 'GER'
and (team1='GER' or team2='GER');

-- 9. Show teamname and the total number of goals scored
SELECT teamname, count(matchid)
  FROM eteam JOIN goal ON id=teamid
group by teamname
 ORDER BY teamname;
 
-- 10. Show the stadium and the number of goals scored in each stadium.
select gm.stadium, count(matchid)
from game gm join goal gl on (gm.id=gl.matchid)
group by gm.stadium;

-- 11. For every match involving 'POL', show the matchid, date and the number of goals scored.
SELECT matchid,mdate, count(matchid)
  FROM game JOIN goal ON matchid = id 
 WHERE (team1 = 'POL' OR team2 = 'POL')
group by matchid, mdate;

-- 12. For every match where 'GER' scored, show matchid, match date and the number of goals scored 
-- by 'GER'
select gm.id, gm.mdate, count(gl.gtime)
from goal gl join game gm on (gl.matchid=gm.id)
where gl.teamid = 'GER'
group by gm.id, gm.mdate

-- 13. List every match with the goals scored by each team as shown. This will use "CASE WHEN" which 
-- has not been explained in any previous exercises.
-- Sort your result by mdate, matchid, team1 and team2.

-- starter code
-- SELECT mdate,
--  team1,
--  CASE WHEN teamid=team1 THEN 1 ELSE 0 END score1
--  FROM game JOIN goal ON matchid = id
  
-- solution from someone else
-- select mdate,
-- team1,
-- sum(case when teamid = team1 then 1 else 0 end) as score1,
-- team2,
-- sum(case when teamid = team2 then 1 else 0 end) as score2
-- from goal inner join game on goal.matchid = game.id
-- group by game.id, mdate, team1, team2
-- order by mdate, matchid, team1, team2;
