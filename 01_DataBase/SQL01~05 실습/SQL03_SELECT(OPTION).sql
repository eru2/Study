-- 1
SELECT STUDENT_NAME AS " 학생 이름", STUDENT_ADDRESS AS "주소지"
FROM TB_STUDENT
ORDER BY STUDENT_NAME;

-- 2
SELECT STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
ORDER BY SUBSTR(STUDENT_SSN,1,2) DESC;
--만 나이가 아닌 그냥 나이로만 계산했을 경우는 사용가능
--ORDER BY SUBSTR(STUDENT_SSN, 1, 6) DESC;
-- 만 나이를 사용하였을때 사용 (이게 더 정확한듯)
-- 3
SELECT STUDENT_NAME AS "학생이름", STUDENT_NO AS "학번", STUDENT_ADDRESS AS "거주지 주소"
FROM TB_STUDENT
ORDER BY STUDENT_NAME;
--주소기자 강원도나 경기도인 학생들 중 1900년대 학변을 가진 학생들 조회인데 그냥 학생들 조회함

SELECT STUDENT_NAME AS "학생이름", STUDENT_NO AS "학번", STUDENT_ADDRESS AS "거주지 주소"
FROM TB_STUDENT
WHERE STUDENT_NO LIKE '9%' --SUBSTR(STUDENT_NO, 1, 1) = 9
 AND (STUDENT_ADDRESS LIKE '%강원도%'
    OR STUDENT_ADDRESS LIKE '%경기도%')
ORDER BY STUDENT_NAME;
/*
SELECT STUDENT_NAME 학생이름, STUDENT_NO 학번, STUDENT_ADDRESS "거주지 주소"
FROM TB_STUDENT
WHERE STUDENT_NO LIKE '9%'
      AND (STUDENT_ADDRESS LIKE '강원도%'
           OR STUDENT_ADDRESS LIKE '경기도%')
ORDER BY 1;
*/

-- 4
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '법학과'
ORDER BY SUBSTR(PROFESSOR_SSN,1, 2);

/*
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                        FROM TB_DEPARTMENT
                        WHERE DEPARTMENT_NAME = '법학과')
ORDER BY 2;
*/

-- 5
SELECT STUDENT_NO, POINT
FROM TB_GRADE
WHERE TERM_NO = '200402'
AND CLASS_NO = 'C3118100'
ORDER BY POINT DESC, STUDENT_NO;

-- 6
SELECT STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY STUDENT_NO;

-- 7
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO);

-- 8
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS
JOIN TB_CLASS_PROFESSOR USING (CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);

-- 9
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS C
JOIN TB_CLASS_PROFESSOR CP USING (CLASS_NO)
JOIN TB_PROFESSOR P USING(PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON (P.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회';

-- 10
SELECT S.STUDENT_NO AS "학번", S.STUDENT_NAME AS "학생 이름", ROUND(AVG(G.POINT),1) AS "전체 평점"
FROM TB_STUDENT S 
JOIN TB_DEPARTMENT D ON S.DEPARTMENT_NO = D.DEPARTMENT_NO
JOIN TB_GRADE G ON S.STUDENT_NO = G.STUDENT_NO
WHERE D.DEPARTMENT_NAME = '음악학과'
GROUP BY S.STUDENT_NO, S.STUDENT_NAME
ORDER BY S.STUDENT_NO;

-- 11
SELECT DEPARTMENT_NAME AS "학과이름", STUDENT_NAME AS "학생이름", PROFESSOR_NAME AS "지도교수이름"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';

-- 12
SELECT STUDENT_NAME, TERM_NO
FROM TB_CLASS
JOIN TB_GRADE USING (CLASS_NO)
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE TERM_NO LIKE '2007%'
AND CLASS_NAME = '인간관계론';

-- 13
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;

-- 14
SELECT STUDENT_NAME AS " 학생이름", NVL(PROFESSOR_NAME, '지도교수 미지정') AS "지도교수"
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR P ON (S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '서반아어학과'
ORDER BY STUDENT_NO;

-- 15 
SELECT STUDENT_NO AS "학번", STUDENT_NAME AS "이름", DEPARTMENT_NAME AS "학과 이름", AVG(POINT) AS "평점"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING (STUDENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4.0
ORDER BY "평점" DESC;

-- 16 
SELECT CLASS_NO, CLASS_NAME, AVG(POINT)
FROM TB_CLASS 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING (CLASS_NO)
WHERE DEPARTMENT_NAME = '환경조경학과'
AND CLASS_TYPE LIKE '전공%'
GROUP BY CLASS_NO, CLASS_NAME
ORDER BY AVG(POINT) DESC;


-- 17
SELECT STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_STUDENT
                       WHERE STUDENT_NAME = '최경희');

-- 18
SELECT STUDENT_NO,STUDENT_NAME, AVG(POINT)
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING (STUDENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
GROUP BY STUDENT_NO, STUDENT_NAME
HAVING AVG(POINT) = (SELECT MAX(AVG(POINT))
                       FROM TB_STUDENT 
                       JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
                       JOIN TB_GRADE USING (STUDENT_NO)
                       WHERE DEPARTMENT_NAME = '국어국문학과'
                       GROUP BY STUDENT_NO
                       );

/*
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
     JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
     JOIN TB_GRADE USING(STUDENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
GROUP BY STUDENT_NO, STUDENT_NAME
HAVING AVG(POINT) = (SELECT MAX(AVG(POINT))
                     FROM TB_GRADE
                     WHERE STUDENT_NO IN (SELECT STUDENT_NO
                                         FROM TB_STUDENT
                                         WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                                                                FROM TB_DEPARTMENT
                                                                WHERE DEPARTMENT_NAME = '국어국문학과'))
                     GROUP BY STUDENT_NO);
*/

/*
SELECT STUDENT_NO, STUDENT_NAME
FROM (SELECT STUDENT_NO, STUDENT_NAME, AVG(POINT)
      FROM TB_GRADE
           JOIN TB_STUDENT USING(STUDENT_NO)
      WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                             FROM TB_DEPARTMENT
                             WHERE DEPARTMENT_NAME = '국어국문학과')
      GROUP BY STUDENT_NO, STUDENT_NAME
      ORDER BY AVG(POINT) DESC)
WHERE ROWNUM = 1;
*/

-- 19
SELECT DEPARTMENT_NAME AS "계열 학과명", ROUND(AVG(POINT), 1) AS "전공평점"
FROM TB_DEPARTMENT
JOIN TB_CLASS USING(DEPARTMENT_NO)
JOIN TB_GRADE USING (CLASS_NO)
WHERE CATEGORY = (SELECT CATEGORY
                  FROM TB_DEPARTMENT
                  WHERE DEPARTMENT_NAME = '환경조경학과')
GROUP BY DEPARTMENT_NAME
ORDER BY ROUND(AVG(POINT), 1);

