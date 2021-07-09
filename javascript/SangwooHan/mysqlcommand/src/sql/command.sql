create table command(
command_no int not null auto_increment,
username varchar(200) not null,
command varchar(200) not null,
commandmean varchar(200) not null,
reg_date timestamp not null default now(),
primary key(command_no)
);