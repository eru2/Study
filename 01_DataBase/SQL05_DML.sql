-- 1
ALTER TABLE TB_CLASS_TYPE MODIFY NAME VARCHAR2(20);

INSERT INTO TB_CLASS_TYPE
VALUES(01, '전공필수');
INSERT INTO TB_CLASS_TYPE
VALUES(02, '전공선택');
INSERT INTO TB_CLASS_TYPE
VALUES(03, '교양필수');
INSERT INTO TB_CLASS_TYPE
VALUES(04, '교양선택');
INSERT INTO TB_CLASS_TYPE
VALUES(05, '논문지도');

-- 2
CREATE TABLE TB_STUDENT_INFO
AS (SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
    FROM TB_STUDENT);

-- 3
--CREATE TABLE TB_KOL_INFO
--AS (SELECT STUDENT_NO, STUDENT_NAME, B_YEAR, PROFESSOR_NAME
--    FROM TB_STUDENT
    
SELECT STUDENT_NO, STUDENT_NAME, 19 || SUBSTR( STUDENT_SSN, 1, 2) AS "출생년도", PROFESSOR_NAME
FROM TB_STUDENT S
JOIN TB_PROFESSOR P ON (S.DEPARTMENT_NO = P.DEPARTMENT_NO)
JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
AND ;

-- 4
UPDATE TB_DEPARTMENT
SET CAPACITY = ROUND((CAPACITY*0.1) + CAPACITY);

-- 5
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '서울시 종로구 숭인동 181-21'
WHERE STUDENT_NO = 'A413042';

-- 6


-- 7


-- 8
DELETE FROM TB_GRADE_TEST
WHERE STUDENT_NO = (SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE ABSENCE_YN = 'Y');


--https://foggy-shoe-029.notion.site/AWS-Devops-15ea51a099f480f897aad48158bc56e2