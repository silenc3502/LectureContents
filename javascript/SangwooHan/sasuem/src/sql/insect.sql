create table insect(
insect_no int not null auto_increment,
username varchar(200) not null,
insectname varchar(200) not null,
old varchar(200) not null,
habitat varchar(200) not null,
description text not null,
reg_date timestamp not null default now(),
primary key(insect_no)
);