create database if not exists vehicles;
use vehicles;
drop table if exists cars;
create table cars(
carId int(15) not null auto_increment,
make varChar(15) not null,
model varChar(15) not null,
year int(4) not null,
primary key(carId)
);