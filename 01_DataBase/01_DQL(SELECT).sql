/*

 테이블
 - 데이터베이스에서 데이터를 저장하는 기본 개념
 - 행과 열로 구성된 데이터 집합
 
 컬럼
 - 테이블 내의 각 데이터 속성을 정의하는 필드
 - 컬럼은 테이블에서 저장할 때 속성 = 값으로 저장한다.
 
 => 테이블은 여러 컬럼으로 구성되어있고, 각 컬럼은 테이블이 표현하는 데이터의 세부적인 속성을 나타냄.
 
 <SELECT>
  SELECT 가지고 오고싶은 정보 FROM 테이블;
  SELECT 컬럼1, 컬럼2, .... FROM 테이블;

*/
  
  -- 모든 사람의 정보를 찾아줘.
  SELECT * 
  FROM employee;
  
  -- 모든 사원의 이름, 핸드폰 번호, 주민번호
  SELECT EMP_NAME, EMP_NO, PHONE 
  FROM employee;
  
  
  --------실습------------
  -- JOB 테이블의 직급명 컬러만 조회
  SELECT JOB_NAME 
  FROM JOB;
  -- DEPARTMENT 테이블의 모든 칼럼 조회
  SELECT * 
  FROM DEPARTMENT;
  -- DEPARTMENT 테이블의 부서코드, 부서명 조회
  SELECT DEPT_ID, DEPT_TITLE 
  FROM DEPARTMENT
  -- EMPLOYEE 테이블의 사원명, 이메일, 전화번호, 입사일, 급여 조회
  SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY 
  FROM EMPLOYEE;
  
  
   -- <컬럼값을 통한 산술연산>
   -- SELECT절 컬럼명 작성부부네 산술 연산을 할 수 있다.
   -- EMPLOYEE 테이블의 사원명, 사원의 연봉(SALARY * 12)를 조회
   SELECT EMP_NAME, SALARY * 12 
   FROM EMPLOYEE;
   
   -- EMPLOYEE 테이블의 사원명, 급여, 보너스, 사원의 보너스 포함 연봉((급여 + 보너스) * 급여)를 조회
   SELECT EMP_NAME, SALARY, BONUS, ((SALARY + (SALARY * BONUS)) * 12) 
   FROM EMPLOYEE;
   
   -- 데이터베이스에서 NULL은 빈 값을 의미한다.
   -- 모든 연산에 NULL 값이 포함된 경우 결과는 NULL이 된다.
   
   -- 사원명, 입사일, 근무일수를 EMOLOYEE 테이블에서 조회
   -- 데이터베이스에서는 날짜를 계산할 때 덧셈, 뺄셈이 가능
   -- 현재 시간 - 입사일 = 근무한시간
   -- DATE - DATE => 결과는 무조건 일로 표시가 된다.
   -- 코드실행시 현재 날짜를 표시하는 상수 : SYSDATE (년/월/일/시/분/초)
   SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE 
   FROM EMPLOYEE;
   
   SELECT SYSDATE 
   FROM DUAL;
   --Dual은 oracle에서 제공하는 가상 테이블
   
/*
   <컬럼에 별칭 지정하기>
   산술연산을 하게되면 컬럼며이 지저분해진다. 이때 컬럼명에 별칭을 부여해서 깔끔하게 가져올 수 있다.
   [표현법]
   컬럼명 별칭/ 컬럼명 as 별칭 / 컬럼명 "별칭" / 컬럼명 AS "별칭"
   띄어쓰기를 사용하려면 " "있는 곳에서 사용
*/

SELECT EMP_NAME 사원명, SALARY AS 급여, BONUS "보너스", (SALARY * 12) AS "연봉" 
FROM EMPLOYEE;
/*
SELECT SAL
FROM (EMP_NAME 사원명, SALARY AS 급여, BONUS "보너스", (SALARY * 12) AS "SAL"
      FROM EMPLOYEE);
*/

/* 
 임의의 값 : <리터럴>
 임의로 지정한 문자열('')
 문자열은 모두 ' ' 로 표현한다.
*/

--EMPLOYEE 테이블의 사번, 사원명, 급여
SELECT EMP_ID , EMP_NAME, SALARY, '원' AS "단위" 
FROM EMPLOYEE;

/*
 <연결 연산자 : ||>
 여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있다.
 
*/

 --사번, 이름, 급여를 하나의 컬럼으로 조회
 SELECT EMP_ID || EMP_NAME || SALARY 
 FROM EMPLOYEE;
 
 
 --EMPLOYEE테이블에서 모든 사원의 월급을 조회한다.
 --다음과 같이 결과가 나오도록 출력하라
 --XX의 월급은 XX원 입니다.
 SELECT EMP_NAME || '의 월급은 ' || SALARY ||'원 입니다.' AS "모든 사원의 월급" 
 FROM EMPLOYEE;
 
 /*
 
 <DISTINCT>
 중복제거 - 컬럼에 표시된 값들을 한번씩만 조회하고자 할 때 사용한다.

*/

SELECT JOB_CODE 
FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE 
FROM EMPLOYEE;

SELECT DEPT_CODE 
FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE 
FROM EMPLOYEE;

--SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE FROM EMPLOYEE;
--위와 같이 작성시 에러가 발생한다. DISTINCT는 한 명령어에서 한번만 사용가능

SELECT DISTINCT JOB_CODE, DEPT_CODE 
FROM EMPLOYEE;

--위처럼 사용시 JOB_CODE와 DEPT_CODE를 쌍으로 묶어서 중복을 제거한 값을 보여준다. 
-- J3 D6가 2개있으면 J3 D6는 하나로 나오고 J3 D5는 J3 D6와 J3는 중복되지만 D5는 중복되지 않으니 J3 D5는 값은 제거되지 않고 그대로 출려한다. 
-- 즉 두 값을 하나로 묶어서 두 값이 모두 중복되지 않으면 제거되지 않는다.


/*

 <WHERE 절>
 조회하고자하는 테이블로부터 특정 조건에 만족하는 데이터만 조회할 때 사용
 조건식에서도 다양한 연산자를 사용할 수 있다.
 
 [표현법]
 SELECT 컬럼, 컬럼, 컬럼 FROM 테이블명 WHERE 조건;

 >>비교연산자<<
 >, <, >=, <=, : 대소비교
 = : 양쪽이 동일하다
 !=, <>, *= : 양쪽이 다르다
*/
--EMPLOYEE 테이블에서 부서코드가 D9인 사원들만 조회를 하겠다.

SELECT * 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D9';

--EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D1';

첫 수업 소감 및 목표
--EMPLOYEE에서 부서코드가 'D1'이 아닌 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE != 'D1';

--월급이 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE 
WHERE SALARY >= 4000000;

------------------------------------------------실습-----------------------------------------------------
--급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭 -> 연봉) 조회
SELECT EMP_NAME, SALARY, HIRE_DATE, (SALARY * 12) AS "연봉" 
FROM EMPLOYEE 
WHERE SALARY >= 3000000;
--연봉이 5천만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭 -> 연봉), 부서코드 조회
SELECT EMP_NAME, SALARY, HIRE_DATE, (SALARY * 12) AS "연봉", DEPT_CODE 
FROM EMPLOYEE
WHERE (SALARY * 12) >= 50000000;
--직급코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN
FROM EMPLOYEE 
WHERE JOB_CODE != 'J3';
-- 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
--중간에 AND, OR로 조건을 연결할 수 있다.
SELECT EMP_NAME, EMP_ID, SALARY 
FROM EMPLOYEE 
WHERE SALARY >= 3500000 AND SALARY <= 6000000;


/*

    <AND, OR 연산자>
    조건을 여러개 연결할 때 사용한다.
    
    [표현법]
    조건A AND 조건B -> 조건A와 조건B가 모두 만족하는 값만 참으로 한다.
    조건A OR 조건B -> 조건A와 조건B 중 하나만 만족해도 값을 참으로 한다.
    
    <BETWEEN AND>
    조건식에 사용되는 구문
    몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 주로 사용하느 연산자(이상, 이하만 가능)
    
    [표현법]
    비교대상 커럼 BETWEEN 하안값 AND 상한값;

*/

-- 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY FROM EMPLOYEE WHERE SALARY BETWEEN 3500000 AND 6000000;
-- 급여가 350만원 이상 600만원 이하가 아닌 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY FROM EMPLOYEE WHERE SALARY NOT BETWEEN 3500000 AND 6000000;

--NOT : 논리부족 연산자
-- 컬럼명앞에 또는 BETWEEN 앞에 선언가능

--입사일이 '90/01/01' 이상 '01/01/01'이하인 사원들을 전체 조회
SELECT EMP_NAME, HIRE_DATE 
FROM EMPLOYEE
--WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';
WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';

-- NULL을 비교연산할때는 =를 사용할 수 없다.
-- NULL 값을 비교할때는 IS NULL, IS NOT NULL을 사용한다.
SELECT * 
FROM EMPLOYEE
--WHERE BONUS IS NULL;
WHERE BONUS IS NOT NULL;



----------------------------------------------------------------------------------

/*

   <LIKE>
   비교하고자하는 칼럼값이 내가 제시한 특정 패턴에 만족할 경우 조회
   
   [표현법]
   비교할 대사컬럼 LIKE "특정패턴"; -> 일치하는 것만 가져온다.
   
   특정패턴을 제시할 때 와일드카드라는 특정패턴이 정의도어있다.
   1. '%' : 포함 문자 검색(0글자 이상 전부 조회)
   이 자리에는 뭐가 오든 상관없다는 것을 보이기 때문에 비교할 대상 컬럼 LIKE '%'를 하면 모든 값을 가져온다.
   EX) 비교할 대상 컬럼 LIKE '문자%' : 비교할 대상 컬럼 값 중에서 해당 문자로 시작하는 값들을 전부 가져온다.
       비교할 대상 컬럼 LIKE '%문자' : 비교할 대상 컬럼 값 중에서 해당 문자로 끝나는 값들을 전부 가져온다.
       비교할 대상 컬럼 LIKE '%문자%' : 비교할 대상 컬럼 값 중에서 해당 문자를 포함하는 모든 값을 전부 가져온다.
   
   2.'_' : 1글자를 대체검색할 때 사용
   _하나당 어떤 문자든 상관없이 한글자 즉, __이면 2글자가 들어와도 상관없다.
   EX) 비교할 대상 컬럼 LIKE '_문자' : 비교할대상컬럼값 문자 앞에 아무 글자나 딱 한글자가 있는 값을 조회
       비교할 대상 컬럼 LIKE '문자_' : 비교할대상컬럼값 문자 뒤에 아무 글자나 딱 한글자가 있는 값을 조회
       비교할 대상 컬럼 LIKE '_문자_' : 비교할대상컬럼값 문자 앞뒤에 아무 글자나 딱 한글자씩 있는 값을 조회
       
       비교할 대상 컬럼 LIKE '__문자__' : 내가 원하는 형태로 _를 통해서 문자수를 조절할 수 있다.
   

*/

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

--사원들 중에 이름에 중간에 '하'라는 글자가 포함된 사원의 이름, 전화번호 출력

SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_하%';

--사원들 중에서 전화번호 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

--이메일 중 _앞글자가 3글자인 사원들의 사번, 이름, 이메일
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '____%'; -> 와일드카드로 인식되기 때문에 정상적으로 출력할 수 없다.
--와일드카드와 일반문자를 구분해주어야 한다.
--데이터값으로 취급하고싶은 와일드카드 문자 앞에 나만의 탈출문자를 제시해서 탈출시켜주면 된다.
--ESCAPE OPTION을 등록해서 사용
WHERE EMAIL LIKE'___\_%' ESCAPE '\';



---==================================================================================

/*

   <IN>
   WHERE 절에 비교대상 컬럼값이 내가 제시한 목록 중에 일치하는 값이 있는지를 검사하는 문법
   
   [표현법]
   비교대상 컬럼 IN {'값', '값', '값'. .}
   

*/

--부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드, 급여 조회

SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN('D6', 'D8', 'D5');


/*
   <연산자 우선순위
   1. 산술연산자
   2. 연결연산자
   3. 비교연산자
   4. IS NULL / LIKE / IN
   5. BETWEEN A AND B
   6. NOT
   7. AND
   8.OK
   

*/

--============================================================================

-- 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '%연';

--전화번호 처음 3자리가 010이 아닌 사원들의 서원명, 전화번호 조회
SELECT EMP_NAME, PHONE 
FROM EMPLOYEE 
WHERE PHONE NOT LIKE '010%';

-- 이름에 '하'가 포함되어있고 급여가 240먼원 이상인 사원들의 사원명, 급여조회
SELECT EMP_NAME, SALARY 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;

-- 부서[DEPT]테이블에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE 
FROM DEPARTMENT 
WHERE DEPT_TITLE LIKE '해외영업%';

-- 사수(MANAGER)가 없고 부서배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE 
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 연봉이 3천만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, (SALARY * 12) AS "연봉", BONUS 
FROM EMPLOYEE
WHERE (SALARY * 12) >= 30000000 AND BONUS IS NULL;

-- 입사일이 '95/01/01'이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE 
FROM EMPLOYEE 
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;

-- 급여가 200만원 이상이고 500만원 이하인 사원 중에서 입사일이 '01/01/01'이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS 
FROM EMPLOYEE 
WHERE SALARY BETWEEN 2000000 AND 5000000 
  AND HIRE_DATE >= '01/01/01' 
  AND BONUS IS NULL;

-- 보너스를 포함 연봉((SALARY + (SALARY * BONUS)) *12 )이 NULL이 아니고 이름에 '하'가 포함된 사원들의 사번, 사원명, 급여, 보너스포함 연봉 조회
SELECT EMP_ID, EMP_NAME, SALARY, ((SALARY + (SALARY * BONUS)) *12) AS "보너스 포함 연봉" 
FROM EMPLOYEE 
WHERE ((SALARY + (SALARY * BONUS)) *12 ) IS NOT NULL 
  AND EMP_NAME LIKE '%하%'; 



