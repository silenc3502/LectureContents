create table user(
    user_no int not null auto_increment,
    name varchar(50) not null,
    id varchar(50) not null,
    password varchar(50) not null,
    email varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(user_no)

);