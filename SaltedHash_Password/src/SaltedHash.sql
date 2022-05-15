create database sems;

use sems;
create table user1(
id varchar(30) PRIMARY KEY not null,
emri varchar(30),
mbiemri varchar(30),
email varchar(40) ,
salted_hash varchar(260),
salted varchar(100)
);



