create database ParkingProject on primary(
   name=parkingp,
   filename='E:\data\parkingp.mdf',
   size=10mb,
   filegrowth= 5mb,
   maxsize=unlimited
) log on(
   name=parkingp_log,
   filename='E:\data\parkingp_log.ldf',
   size=10mb,
   filegrowth= 5mb,
   maxsize=unlimited
  )
  
use ParkingProject;

create table admins(
    idadmin int not null ,
    adminName nvarchar(30),
    email nvarchar(30),
    adminPassword nvarchar(10),
    phone_number nvarchar(11),
	constraint ida primary key (idadmin)
)

create table operators(
    idoperator int  not null ,
    operatorName nvarchar(30) not null,
    email nvarchar(30) not null,
    operatorPassword nvarchar(10) not null,
    phone_number nvarchar(11) not null,
	checkLoggedin int not null,  
	constraint ido primary key (idoperator)
)

create table customers(
    customerName nvarchar(30) not null,
    plateNumber nvarchar(6) not null,
	IDticket int not null,

    constraint ID foreign key (IDticket) references ticket(idticket)

)

create table Ticket(
    idticket int not null identity(2,1),
    arrivalTime nvarchar(25) not null,
    departureTime nvarchar(25),
    dateTicket nvarchar(25) not null,
	idoperator1 int ,
	iDspot int not null,
	MoneyToPay int,
	constraint idt primary key (idticket),
	constraint idop foreign key (idoperator1) references Operators(idoperator) ON DELETE SET NULL,
    constraint idsp foreign key (iDspot) references Spot(idspot)

)

create table Spot(
    idspot int not null identity(1,1),
    spot_description nvarchar(5),
    checkfree int,
	constraint ids primary key (idspot)
)

INSERT INTO admins (idadmin,adminName,email,adminPassword,phone_number) VALUES (1,'ahmed','ahmed@gmail.com','Ahmed@1','01478451236');
INSERT INTO Spot (spot_description,checkfree) VALUES ('A3',0)
INSERT INTO operators (idoperator,operatorName,email,operatorPassword,phone_number,checkLoggedin) VALUES (1,'mohammed','mohammed@gmail.com','Mohammed$4','01784551236',1)
INSERT INTO operators (idoperator,operatorName,email,operatorPassword,phone_number,checkLoggedin) VALUES (2,'samy','samy@gmail.com','Samy$4','01784551236',0)
UPDATE operators SET phone_number='01321014785' WHERE idoperator=1
DELETE FROM operators WHERE idoperator=2
SELECT * FROM operators
DELETE FROM Spot WHERE spot_description='a'
	/*constraint plateno primary key (plateNumber),*/