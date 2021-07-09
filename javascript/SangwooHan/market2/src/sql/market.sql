create table market(
market_no int not null auto_increment,
username varchar(200) not null,
name varchar(200) not null,
price int not null,
description text not null,
reg_date timestamp not null default now(),
primary key(market_no)
);