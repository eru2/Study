/*

    <VIEW 뷰>
    
    SELECT 문(쿼리문)을 저장해서 사용할 수 있는 객체
    (자주 사용하는 SELECT문을 저장해두면 긴 SELECT문을 매번 다시 기술할 필요없이 사용할 수 있다.)
    가상테이블 -> 실제 데이터가 담겨 있는 것은 아니다(논리테이블)

*/

--한국에서 근문하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국';

--러시아에서 근문하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '러시아';

--일본에서 근문하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '일본';

/*

    1. VIEW 생성 방법
    
    [표현식]
    CREATE VIEW 뷰명
    AS (서브쿼리)

*/

CREATE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE));
--insufficient privileges권한 필요
--관리자 계정으로 변경

GRANT CREATE VIEW TO C##KH; --VIEW 생성 권한

--학습용 계정으로 변경

SELECT *
FROM VW_EMPLOYEE;

--실제 실행되는 것은 서브쿼리(인라인뷰)로 실행된다고 볼 수 있다.

--한국에서 근문하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '한국';

--러시아에서 근문하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';

--일본에서 근문하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '일본';

--CREATE OR REPLACE
--VIEW가 없을 때는 생성, 이미 존재한다면 수정할 수 있다.

CREATE OR REPLACE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE));

SELECT * FROM VW_EMPLOYEE;


------------------------------------------------------------------------------------------

/*

    뷰 컬럼에 별칭 부여
    서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어있다면 반드시 별칭을 부여 해야한다.

*/

CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID, EMP_NAME, JOB_NAME, 
    DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') AS "GENDER",
    EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) AS "SERVICEYEAR"
    FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE));
    
/*
CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID, EMP_NAME, JOB_NAME, 
    DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여')",
    EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
    FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE));
    이 식은 열의 별명과 함께 지정해야 한다. 라는 오류가 발생한다.
*/

SELECT * FROM VW_EMP_JOB;


SELECT *
FROM VW_EMP_JOB
WHERE SERVICEYEAR >= 20;


DROP VIEW VW_EMP_JOB;
--VIEW 삭제

----------------------------------------------------------------------------------------------

--생성된 뷰를 통해서 DML(INSERT, UPDATE, DELETE) 사용가능하다.
--뷰를 통해서 조작하게되면 실제 데이터가 담겨있는 테이블에 반영된다.

CREATE OR REPLACE VIEW VW_JOB
AS (SELECT JOB_CODE, JOB_NAME
    FROM JOB);
    
SELECT * FROM VW_JOB; --논리테이블(실제 데이터가 담겨있지 않다.)
SELECT * FROM JOB;

INSERT INTO VW_JOB VALUES('J8', '인턴');

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

------------------------------------------------------------------------------------------------

/*

    *DML 명령어로 조작이 불가능한 경우
    
    1) 뷰에 정의되어 있지 않은 컬럼을 조작하려는 경우
    2) 뷰에 정의되어 있지 않은 컬럼 중에 베이스 테이블 상에 NOT NULL제약조건이 지정되어있는 경우
    3) 산술 연산식이나 함수식을 사용한 경우
    4) 그룸 함수나 GROUP_BY 정을 포함한 경우
    5) DISTINCT구문이 포함된 경우
    6) JOIN을 이용해서 여러테이블을 연관시켜놓은 경우
    
    대부분 뷰를 조회를 목적으로 사용한다. 그냥 뷰를 통한 DML은 사용하지 않는 것이 좋다.

*/

/*

    VIEW 옵션
    
    [상세한표현식]
    CREATE (OR REPLACE) (FORCE | NOFORCE) VIEW 뷰명
    AS 서브쿼리
    (WITH CHECK OPTION)
    (WITH READ ONLY)
    
    FORCE | NOFORCE
       -> FROCE : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰를 생서해라.
       -> NOFORCE : 서브쿼리에 기술된 테이블이 존재하는 테이블이여야만 한다.(기본값)
       
    WITH CHECK OPTION : DML시 서브쿼리에 기술된 조검에 부함한 값으로만 DML이 가능하도록 하는 옵션
    WITH READ ONLY : 뷰에 대해서 조회만 가능하도록 하는 옵션

*/

-- FROCE | NOFORCE
CREATE OR REPLACE NOFORCE VIEW VW_EMP
AS (SELECT TCODE, TNAME, TCONTENT
    FROM TT);
--테이블이 없기 때문에 생성이 안됨

--서브쿼링에 기술된 테이블이 존재하지 않아도 뷰가 우선은 생성이 된다.
CREATE OR REPLACE FORCE VIEW VW_EMP
AS (SELECT TCODE, TNAME, TCONTENT
    FROM TT);
-- 컴파일 오류와 함께 뷰가 생성됨

SELECT * FROM VW_EMP;
-- 생성은 되었지만 사용은 불가능하다 

CREATE TABLE TT(
       TCODE NUMBER,
       TNAME VARCHAR2(20),
       TCONTENT VARCHAR2(20)
       );

SELECT * FROM VW_EMP;
-- 나중에라도 테이블을 생성한 뒤 조회를 하면 가능하다. 

--WITH CEHCK OPTION
CREATE OR REPLACE VIEW VW_EMP
AS (SELECT *
    FROM EMPLOYEE
    WHERE SALARY >= 3000000);

SELECT * FROM VW_EMP;

--200번 사원 급여를 200만원으로 변경
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;

ROLLBACK;

CREATE OR REPLACE VIEW VW_EMP
AS (SELECT *
    FROM EMPLOYEE
    WHERE SALARY >= 3000000)
WITH CHECK OPTION;
-- VW_EMP에 WITH CHECK OPTION 부여

--200번 사원 급여를 200만원으로 변경
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;
--오류 발생 WITH CHECK OPTION으로 지금 UPDATE 하려는 값이 VIEW에 있는 옵션에 위반된다 를 알림

--WITH READ ONLY ; 뷰에 대해서 조회만 가능하도록 설정
CREATE OR REPLACE VIEW VW_EMP
AS (SELECT EMP_ID, EMP_NAME, BONUS
    FROM EMPLOYEE
    WHERE BONUS IS NOT NULL)
WITH READ ONLY;

SELECT * FROM VW_EMP;

DELETE
FROM VW_EMP
WHERE EMP_ID = 200;
--오류 발생 : WITH READ ONLY 옵션으로 인하여 DML문을 막고 뷰에 대해서 조회만 가능하도록 설정 되어있다.











