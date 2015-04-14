/*Tables*/
drop table users;
CREATE TABLE users
(
id varchar(30),
device_id varchar(255),
mobile varchar(10),
email_id varchar(255),
password varchar(255),
userrole varchar(255),
logincount int,
create_date timestamp,
lastupdate_date timestamp,
lastlogin_date timestamp
);

ALTER TABLE users
ADD CONSTRAINT pk_users_id PRIMARY KEY (id);

ALTER TABLE users
ADD CONSTRAINT unique_device_id Unique (device_id);





/*Hibernate Sequences*/
---userid registration sequence---
create sequence sequence_userid;