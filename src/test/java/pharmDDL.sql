SELECT * FROM users
SELECT * FROM pharmacy
SELECT * FROM drug
SELECT * FROM inventory
SELECT * FROM cart

DROP TABLE users
DROP TABLE pharmacy
DROP TABLE drug
DROP TABLE inventory
DROP TABLE cart

INSERT INTO pharmacy(name,address,phone) VALUES ('아주대약국', '우만동', '0312199999')
INSERT INTO pharmacy(name,address,phone) VALUES ('우만동약국', '우만동', '0312198888')
INSERT INTO inventory(quantity,drugId) VALUES ('우만동약국', '우만동', '0312198888')
INSERT INTO cart(id,drugId) VALUES ('우만동약국', '우만동', '0312198888')

create table pharmacy(
   pharmaId int auto_increment primary key,
   name varchar(20) not null,
   address varchar(100) not null,
   phone varchar(20) not null 
)

create table drug(
   drugId varchar(500) primary key,
   drugName varchar(500) not null,
   dosage varchar(1000) not null,
   company varchar(500) not null,
   pharmaId int not null,
   foreign key (pharmaId) references pharmacy(pharmaId)
)

create table inventory( 
   invenId int auto_increment primary key,
   quantity int not null,
   drugId varchar(500) not null,
   foreign key (drugId) references drug(drugId)
)

create table users( 
   id varchar(20) primary key,
   pw varchar(20) not null,
   name varchar(20) not null,
   phone varchar(20) not null
)

create table cart(
   cartId int auto_increment primary key,
   id varchar(20) not null,
   drugId varchar(500) not null,
   foreign key (id) references users(id),
   foreign key (drugId) references drug(drugId)
)