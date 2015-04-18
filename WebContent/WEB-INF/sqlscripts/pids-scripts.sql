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


drop table address_details;
CREATE TABLE address_details
(
id varchar(30),
users_id varchar(30),
isprimary varchar(2),
firstname varchar(30),
middlename varchar(30),
mobile varchar(30),
gender varchar(1),
lastname varchar(30),
landmark varchar(30),
address1 varchar(500),
address2 varchar(500),
address3 varchar(500),
city 		varchar(30),
pinnumber varchar(30),
district varchar(30),
state varchar(30),
status varchar(1),
create_date timestamp,
lastupdate_date timestamp,
lastlogin_date timestamp
);

ALTER TABLE address_details
ADD CONSTRAINT pk_address_details_id PRIMARY KEY (id);

ALTER TABLE address_details
ADD FOREIGN KEY (users_id)         
REFERENCES users(id) 

/*ALTER TABLE address_details
DROP CONSTRAINT SYS_C007109;*/


/*
Sequence Creation
*/
--drop sequence sequence_order_detailsid;
create sequence sequence_userid;
create sequence sequence_user_detailsid;
create sequence sequence_address_detailsid;
create sequence sequence_order_detailsid;