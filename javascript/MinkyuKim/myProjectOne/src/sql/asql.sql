use non_jpa_db;

// 회원가입
create table purchasingMemberSignUp(
purchasingMemberSignUp_no int not null auto_increment,
 id varchar(200) not null,
 pw varchar(200) not null,
 pwCheck varchar(200) not null,
 name varchar(20) not null,
 dateOfBirth varchar(50) not null,
 gender varchar(20) not null,
 phoneNumber varchar(200) not null,
 email varchar(200) not null,
 address varchar(200) not null,
 interest varchar(50) not null,
 primary key(purchasingMemberSignUp_no));

// 그림구매,렌탈
 create table artWorkPurchaseBoard(
 ArtworkProduct_no int not null auto_increment,
 salePrice int not null,
 rentalPrice int not null,
 saleTitle varchar not null,
 saleContent not null,
 drawingSize not null,    --->추가필요
 ArtworkProductCreatedDate timestamp not null default now(),
 primary key(DrawingProduct_no));

 saleWriter not null, 작성회원 아이디? 이름으로 자동배치

