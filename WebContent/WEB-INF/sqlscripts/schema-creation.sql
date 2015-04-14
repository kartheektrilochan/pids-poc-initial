CREATE USER testdb
PROFILE DEFAULT
IDENTIFIED BY testdb
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
ACCOUNT UNLOCK;


GRANT create session TO testdb;
GRANT create table TO testdb;
GRANT create view TO testdb;
GRANT create sequence TO testdb;
GRANT UNLIMITED TABLESPACE TO testdb;
grant create schema to testdb;


CREATE SCHEMA AUTHORIZATION testdb;
