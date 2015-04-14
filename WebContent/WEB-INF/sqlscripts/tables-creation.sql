CREATE TABLE user_roles
(
ID varchar(30),
username varchar(255),
password varchar(255),
emailid varchar(255),
role varchar(255),
isactive varchar(50),
lastupdated timestamp,
createddate timestamp,
lastlogin   timestamp,
failurecounts int
); 

ALTER TABLE user_roles
ADD CONSTRAINT unique_username Unique (username);

ALTER TABLE user_roles
ADD CONSTRAINT pk_ID PRIMARY KEY (Id);




CREATE TABLE users
(
id varchar(30),
username varchar(255) not null,
firstname varchar(255) not null,
middlename varchar(255),
lastname varchar(255),
mobilenumber varchar(12) not null,
address1 varchar(255),
address2 varchar(255),
address3 varchar(255),
city varchar(255),
state varchar(255),
landmark varchar(255),
lastupdated timestamp,
createddate timestamp,
customertype varchar(255),
field1 varchar(255),
field2 varchar(255),
field3 varchar(255),
field4 varchar(255)
); 
ALTER TABLE users
ADD CONSTRAINT pk_usersid PRIMARY KEY (id);


CREATE TABLE orders
(
id varchar(30),
orderstatus varchar(255),
ordername varchar(255),
bulkorderid varchar(255),
oderedby varchar(255),
processedby varchar(255),
lastupdated timestamp,
createddate timestamp
);

ALTER TABLE orders
ADD CONSTRAINT pk_orderid PRIMARY KEY (id);

---userid registration sequence---
create sequence sequence_userid;