create table login(
login_no int not null auto_increment,
id varchar(200) not null,
pw varchar(200) not null,
reg_date timestamp not null default now(),
primary key(login_no)
);