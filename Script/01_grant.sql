-- 계정 추가 및 권한 부여

SELECT USER FROM dual;

CREATE USER spring5 IDENTIFIED BY rootroot;
GRANT CONNECT, resource, CREATE synonym, CREATE VIEW TO spring5;

--확인

SELECT * FROM dba_users WHERE username = 'NONAGE';
