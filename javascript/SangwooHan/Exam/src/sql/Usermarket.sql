create table usermarket(
usermarket_no int not null auto_increment,
name varchar(200) not null,
productname varchar(200) not null,
price int not null,
description text not null,
date1 timestamp not null default now(),
primary key(usermarket_no)
);

