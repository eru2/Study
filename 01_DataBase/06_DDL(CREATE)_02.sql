
--관리자계정으로 생성
CREATE USER C##KH IDENTIFIED BY KH;

GRANT CONNECT, RESOURCE TO C##KH;

ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
--KH계정으로 전환

--------------------------------------------------------------------------------------------------------------------------

--테이블을 복제할 수 있다. 여기서부터 KH계정 이용

CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);


DROP TABLE EMPLOYEE_COPY;

--테이블 구조만 복사
CREATE TABLE EMPLOYEE_COPY
AS(SELECT * FROM EMPLOYEE WHERE 1=0);

------------------------------------------------------------------------------------------------------------------------------

/*

    테이블이 다 생성된 후에 제약조건을 추가하는 방법
    ALTER TABLE 테이블명 변경할 내용
    
    -FRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
    -FOREIGN KEY : ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명(컬럼명);
    -UNIQUE : ALTER TABLE 테이블명 ADD UNIQUE(컬럼);
    -CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건식);
    -NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
    

*/

--EMPLOYEE_COPY 테이블에 PRIMARY KEY 제약조건 추가(EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

--EMPLOYEE테이블에 DEPT_CODE에 외래키 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;
--EMPLOYEE테이블에 JOB_CODE에 외래키 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB;
--DEPARTMENT테이블에 LOCATION_ID에 외래키 제약조건 추가
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;























