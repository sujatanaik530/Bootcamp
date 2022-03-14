-- 2.3 A
SELECT d.name as 'Department Name', 
        COUNT(c.id) as 'Number of Courses'
FROM department d INNER JOIN course c ON d.id = c.deptId
GROUP BY d.name
ORDER BY 2 ASC, 1 ASC;

-- submitted
SELECT d.name as 'Department Name', 
        COUNT(c.id) as 'Number of Courses'
FROM department d INNER JOIN course c ON d.id = c.deptId
GROUP BY d.name
ORDER BY 2 ASC, 1 ASC;

-- 3.3 B
SELECT c.name AS 'Course Name', 
			COUNT(sc.studentId) AS 'Number of Students'
FROM course c INNER JOIN studentcourse sc ON c.id = sc.courseId
GROUP BY c.name
ORDER BY 2 DESC, 1 ASC;

-- submitted
SELECT 
  c.name AS 'Course Name', 
  COUNT(sc.studentId) AS 'Number of Students'
FROM course c INNER JOIN studentcourse sc ON c.id = sc.courseId
GROUP BY c.name
ORDER BY 2 DESC, 1 ASC;

-- 4.3 C 1
SELECT c.name AS 'Course Name'
FROM course c LEFT JOIN facultycourse fc ON c.id = fc.courseId
GROUP BY c.name
HAVING COUNT(fc.facultyId) = 0
ORDER BY 1 ASC;

-- submitted
SELECT c.name AS 'Course Name'
FROM course c LEFT JOIN facultycourse fc ON c.id = fc.courseId
GROUP BY c.name
HAVING COUNT(fc.facultyId) = 0
ORDER BY 1 asc;

-- 5.3 C 2
SELECT 
 c.name AS 'Course Name', 
 COUNT(sc.studentId) AS 'Number of Students'
FROM course c LEFT JOIN facultycourse fc ON c.id = fc.courseId
					INNER JOIN studentcourse sc ON sc.courseId = c.id
GROUP BY c.name
HAVING COUNT(fc.facultyId) = 0
ORDER BY 2 DESC, 1 ASC;

-- submitted
SELECT 
 c.name AS 'Course Name', 
 COUNT(sc.studentId) AS 'Number of Students'
FROM course c LEFT JOIN facultycourse fc ON c.id = fc.courseId
              INNER JOIN studentcourse sc ON sc.courseId = c.id
GROUP BY c.name
HAVING COUNT(fc.facultyId) = 0
ORDER BY 2 DESC, 1 ASC;

-- 6.3 D
SELECT COUNT(distinct sc.studentId) AS 'Students', YEAR(sc.startDate) AS 'Year'
FROM studentcourse sc
GROUP BY YEAR(sc.startDate)
ORDER BY 2 ASC, 1 DESC;

-- submitted
SELECT COUNT(distinct sc.studentId) AS 'Students', 
       YEAR(sc.startDate) AS 'Year'
FROM studentcourse sc
GROUP BY YEAR(sc.startDate)
ORDER BY 2 ASC, 1 DESC;

-- 7.3 E
SELECT 
 sc.startDate AS 'Start Date', 
 COUNT(distinct sc.studentId) AS 'Total Number of Students'
FROM studentcourse sc
WHERE MONTH(sc.startDate) = 8
GROUP BY sc.startDate
ORDER BY 1 ASC, 2 ASC;

-- submitted
SELECT 
 sc.startDate AS 'Start Date', 
 COUNT(distinct sc.studentId) AS 'Total Number of Students'
FROM studentcourse sc
WHERE MONTH(sc.startDate) = 8
GROUP BY sc.startDate
ORDER BY 1 ASC, 2 ASC;

-- 8.3 F
-- wrong
SELECT s.firstname AS 'First Name', s.lastname AS 'Last Name', COUNT(sc.courseId) AS 'Number of Courses'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
					INNER JOIN course c ON c.id = sc.courseId
					INNER JOIN department d ON d.id = c.deptId
GROUP BY s.id;

-- in between
SELECT s.firstname AS 'First Name',
			s.lastname AS 'Last Name', 
			s.majorId AS 'Major',
			sc.courseId AS 'Course', 
			d.id AS 'Department'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
					INNER JOIN course c ON c.id = sc.courseId
					INNER JOIN department d ON d.id = c.deptId
ORDER BY 1, 2;

-- in between
SELECT s.firstname AS 'First Name',
			s.lastname AS 'Last Name', 
			s.majorId AS 'Major',
			sc.courseId AS 'Course', 
			d.id AS 'Department'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
					INNER JOIN course c ON c.id = sc.courseId
					INNER JOIN department d ON d.id = c.deptId
WHERE s.majorId = d.id
ORDER BY 1, 2;

-- final
SELECT s.firstname AS 'First Name',
			s.lastname AS 'Last Name', 
			count(sc.courseId) AS 'Number of Courses'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
					INNER JOIN course c ON c.id = sc.courseId
					INNER JOIN department d ON d.id = c.deptId
WHERE s.majorId = d.id
GROUP BY s.firstname, s.lastname
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- submitted
SELECT s.firstname AS 'First Name',
       s.lastname AS 'Last Name', 
       count(sc.courseId) AS 'Number of Courses'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
               INNER JOIN course c ON c.id = sc.courseId
               INNER JOIN department d ON d.id = c.deptId
/* The below condition will get only the courses from their major's dept*/
WHERE s.majorId = d.id
GROUP BY s.firstname, s.lastname
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- 9.3 G
SELECT s.firstname AS 'First Name', 
		s.lastname AS 'Last Name', 
		round(avg(sc.progress), 1) AS 'Average Progress'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
GROUP BY s.firstname, s.lastname
HAVING AVG(sc.progress) < 50
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- submitted
SELECT s.firstname AS 'First Name', 
        s.lastname AS 'Last Name', 
        round(avg(sc.progress), 1) AS 'Average Progress'
FROM student s INNER JOIN studentcourse sc ON s.id = sc.studentId
GROUP BY s.firstname, s.lastname
/* The below condition will extract students with average progress
   less than 50. */
HAVING AVG(sc.progress) < 50
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- 10.3 H 1
SELECT c.name AS 'Course Name', round(AVG(sc.progress), 1) AS 'Average Progress'
FROM course c INNER JOIN studentcourse sc ON c.id = sc.courseId
GROUP BY c.name
ORDER BY 2 DESC, 1 ASC;

-- submitted
SELECT 
 c.name AS 'Course Name', 
 round(AVG(sc.progress), 1) AS 'Average Progress'
FROM course c INNER JOIN studentcourse sc ON c.id = sc.courseId
GROUP BY c.name
ORDER BY 2 DESC, 1 ASC;

-- 11.3 H 2
SELECT c.name AS 'Course Name', 
			round(sc.avgProgress, 1) AS 'Average Progress'
FROM course c INNER JOIN (
							SELECT sc1.courseId AS id, 
									AVG(sc1.progress) AS avgProgress
							FROM studentcourse sc1 
							GROUP BY sc1.courseId 
							ORDER BY 2 desc
							LIMIT 1) sc ON c.id = sc.id;
							
-- submitted
SELECT 
 c.name AS 'Course Name', 
 round(sc.avgProgress, 1) AS 'Average Student Progress'
FROM course c INNER JOIN (
    /* Below subquery will give the course id of the course with 
       maximum average progress in any course and the average 
       progress in that course. */
                            SELECT  sc1.courseId AS id, 
                                    AVG(sc1.progress) AS avgProgress
                            FROM studentcourse sc1 
                            GROUP BY sc1.courseId 
                            ORDER BY 2 desc
                            LIMIT 1) sc ON c.id = sc.id;
							
-- 12.3 H 3
SELECT f.firstname AS 'First Name', f.lastname AS 'Last Name', round(AVG(sc.progress), 1) AS 'Average Progress'
FROM course c INNER JOIN studentcourse sc ON c.id = sc.courseId
					INNER JOIN facultycourse fc ON fc.courseId = c.id
					INNER JOIN faculty f ON f.id = fc.facultyId
GROUP BY f.firstname, f.lastname
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- submitted
SELECT 
 f.firstname AS 'First Name', 
 f.lastname AS 'Last Name', 
 round(AVG(sc.progress), 1) AS 'Average Progress'
FROM course c 
     INNER JOIN studentcourse sc ON c.id = sc.courseId
     INNER JOIN facultycourse fc ON fc.courseId = c.id
     INNER JOIN faculty f ON f.id = fc.facultyId
/* Grouping by faculty member name will give the
   average progress over all his/her courses. */
GROUP BY f.firstname, f.lastname
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- 13.3 H 4
-- REVISIT
SELECT c.name AS 'Course Name', 
			round(sc.avgProgress, 1) AS 'Average Progress'
FROM course c INNER JOIN (
							SELECT sc1.courseId AS id, 
									AVG(sc1.progress) AS avgProgress
							FROM studentcourse sc1 
							GROUP BY sc1.courseId ) sc ON c.id = sc.id
					INNER JOIN facultycourse fc ON c.id = fc.courseId
					INNER JOIN faculty f ON f.id = fc.facultyId
WHERE sc.avgProgress >= 0.9 * MAX(sc.avgProgress);

WITH course_avg_progress AS (
	SELECT courseid AS courseid,
	AVG(progress) AS avgprogress
	FROM studentcourse
	GROUP BY courseid
),
max_avg_progress  AS (
	SELECT MAX(avgprogress) AS map
	FROM course_avg_progress
)
SELECT f.firstname, f.lastname, cap.avgprogress
FROM facultycourse fc INNER JOIN course_avg_progress cap ON fc.courseId = cap.courseid
								INNER JOIN faculty f ON f.id = fc.facultyId
WHERE cap.avgprogress >= 0.9 * max_avg_progress.map;

-- MaxAvgProgressInAnyCourse
SELECT sc.courseId, round(AVG(sc.progress), 1)
FROM studentcourse sc
GROUP BY sc.courseId
ORDER BY 2 DESC
LIMIT 1

-- AvgProgressForFaculty
SELECT fc.facultyId, round(AVG(sc.progress), 1)
FROM studentcourse sc inner JOIN facultycourse fc ON sc.courseId = fc.courseId
GROUP BY fc.facultyId
ORDER BY 2 desc

-- pre-final step
SELECT f.firstname AS 'First Name', 
		f.lastname AS 'Last Name', 
		round(AVG(sc.progress), 1) AS 'Average Progress'
FROM studentcourse sc inner JOIN facultycourse fc ON sc.courseId = fc.courseId
							INNER JOIN faculty f ON f.id = fc.facultyId
GROUP BY f.firstname, f.lastname
HAVING round(AVG(sc.progress), 1) > 0.90 * (SELECT round(AVG(sc.progress), 1)
															FROM studentcourse sc
															GROUP BY sc.courseId
															ORDER BY 1 DESC
															LIMIT 1)
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- submitted
SELECT f.firstname AS 'First Name', 
        f.lastname AS 'Last Name', 
/* Below average is per faculty member, across all his/her courses. */
        round(AVG(sc.progress), 1) AS 'Average Progress'
FROM studentcourse sc 
        inner JOIN facultycourse fc ON sc.courseId = fc.courseId
        INNER JOIN faculty f ON f.id = fc.facultyId
GROUP BY f.firstname, f.lastname
/* Below, we extract only those faculty members, whose average
   progress (average progress across all their courses) is atleast 90% 
   of the maximum average progress per course.
   The subquery in HAVING gives the maximum average progress per course.*/
HAVING round(AVG(sc.progress),1) >= 0.90*(SELECT round(AVG(sc.progress), 1)
                                          FROM studentcourse sc
                                          GROUP BY sc.courseId
                                          ORDER BY 1 DESC
                                          LIMIT 1)
ORDER BY 3 DESC, 1 ASC, 2 ASC;

-- 14.3 I
-- in between
SELECT s.firstname AS 'First Name', 
		s.lastname AS 'Last Name', 
		sc.courseId, 
		sc.progress
FROM student s INNER JOIN studentcourse sc ON s.id =sc.studentId
ORDER BY 1, 2;

-- in between
SELECT s.firstname AS 'First Name', 
		s.lastname AS 'Last Name', 
		min(sc.progress),
		MAX(sc.progress)
FROM student s INNER JOIN studentcourse sc ON s.id =sc.studentId
GROUP BY s.firstname, s.lastname
ORDER BY 1, 2;

-- final
SELECT s.firstname AS 'First Name', 
		s.lastname AS 'Last Name', 
		CASE
			when min(sc.progress) < 40 then 'F'
			when min(sc.progress) < 50 then 'D'
			when min(sc.progress) < 60 then 'C'
			when min(sc.progress) < 70 then 'B'
			when min(sc.progress) >= 70 then 'A'
		END AS 'Minimum Grade',
		CASE
			when max(sc.progress) < 40 then 'F'
			when max(sc.progress) < 50 then 'D'
			when max(sc.progress) < 60 then 'C'
			when max(sc.progress) < 70 then 'B'
			when max(sc.progress) >= 70 then 'A'
		END AS 'Maximum Grade'
FROM student s INNER JOIN studentcourse sc ON s.id =sc.studentId
GROUP BY s.firstname, s.lastname
ORDER BY 3 desc, 4 desc, 1 asc, 2 ASC;

-- submitted
SELECT s.firstname AS 'First Name', 
        s.lastname AS 'Last Name', 
/* Find the minimum progress per student and grade it.*/
        CASE
            when min(sc.progress) < 40 then 'F'
            when min(sc.progress) < 50 then 'D'
            when min(sc.progress) < 60 then 'C'
            when min(sc.progress) < 70 then 'B'
            when min(sc.progress) >= 70 then 'A'
        END AS 'Minimum Grade',
/* Find the maximum progress per student and grade it.*/
        CASE
            when max(sc.progress) < 40 then 'F'
            when max(sc.progress) < 50 then 'D'
            when max(sc.progress) < 60 then 'C'
            when max(sc.progress) < 70 then 'B'
            when max(sc.progress) >= 70 then 'A'
        END AS 'Maximum Grade'
FROM student s INNER JOIN studentcourse sc ON s.id =sc.studentId
GROUP BY s.firstname, s.lastname
ORDER BY 3 desc, 4 desc, 1 asc, 2 asc;

libdbauthorsbooksCustmerMemberShipStatusCustmerMemberShipStatuscustomers