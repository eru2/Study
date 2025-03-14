-- 1
SELECT DEPARTMENT_NAME AS "학과 명", CATEGORY AS "계열"
FROM TB_DEPARTMENT;

-- 2
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명 입니다'
FROM TB_DEPARTMENT;

-- 3
SELECT STUDENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE ABSENCE_YN = 'Y'
AND SUBSTR(STUDENT_SSN, 8, 1) = 2
AND DEPARTMENT_NAME = '국어국문학과';

SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_SSN, 8, 1) = 2
      AND ABSENCE_YN = 'Y'
      AND DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                           FROM TB_DEPARTMENT
                           WHERE DEPARTMENT_NAME = '국어국문학과');

-- 4
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

-- 5 
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 10
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'N'
AND SUBSTR(ENTRANCE_DATE, 1, 2) = 02
AND SUBSTR(STUDENT_ADDRESS, 1, 2) = '전주'; --STUDENT_ADDRESS LIKE '%전주%'가 좀더 정확한 정보를 주었을 것 같다
--전주시로 시작하지 않고 전라북도 전주시로 주소를 적은 학생들은 선택되지 않았으니 그냥 주소에 전주가 포함된 학생들을 조회했어야...
/*
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) = 2002
      AND STUDENT_ADDRESS LIKE '%전주%'
      AND ABSENCE_YN = 'N';
*/
