use shopping;

-- 1. Create tables and keep up the good practices.


CREATE TABLE  Product(
		ProductCode integer,
        ProductName varchar(50),
        UnitPrice integer,
        primary key(ProductCode)
);

CREATE TABLE  Sell(
		ProductCode integer,
        SalesExecutiveID integer,
        CustomerID integer
);

CREATE TABLE  SalesExecutive(
		SalesExecutiveID integer,
        SalesName varchar(50),
        DOB date,
        Mobile integer,
        primary key(SalesExecutiveID)
);

CREATE TABLE Grouped(
		CategoryCode Integer,
        ProductCode Integer
);

CREATE TABLE Buy(
		ProductCode Integer,
        CustomerId Integer,
        DOP date,
        NoOfUnits Integer
);

CREATE TABLE Has(
		CustomerId Integer,
        LocationCode Integer
);

CREATE TABLE Category(
		CategoryCode Integer,
        CategoryName VarChar(50),
        primary key(CategoryCode)
);

CREATE TABLE Customer(
		CustomerId Integer,
        CustomerName varchar(50),
        DOB date,
        Mobile Integer,
        Gender varchar(10),
        primary key(CustomerId)
);

CREATE TABLE Location(
		LocationCode Integer,
        LocationName varchar(50),
        primary key(LocationCode)
);

insert into Product values(1,'Monitor',20000);
insert into Product values(2,'Laptop',70000);
insert into Product values(3,'Mobile',30000);
insert into Product values(4,'Head Phones',5000);

select * from Product;

insert into SalesExecutive values(1,'Yashwanth','1999-10-05',89786);
insert into SalesExecutive values(2,'Sai','1999-10-27',76750);
insert into SalesExecutive values(3,'Vamshi','2000-04-28',98482);
insert into SalesExecutive values(4,'Vishnu','1999-08-17',91823);

select * from SalesExecutive;

insert into Customer values(1,'Umesh','1999-10-27',88976,'Male');
insert into Customer values(2,'Rishi','200-10-12',96409,'Male');
insert into Customer values(3,'Sai Krishna','1999-09-14',89786,'Male');
insert into Customer values(4,'Varun Sai','1999-11-25',91828,'Male');

select * from Customer;

insert into Location values(1,'Suryapet');
insert into Location values(2,'Khammam');
insert into Location values(3,'Nagar Kurnool');
insert into Location values(4,'Warangal');

select * from Customer;

insert into Has values(1,1);
insert into Has values(2,2);
insert into Has values(3,3);
insert into Has values(4,4);

select * from Has;

insert into Sell values(1,1,1);
insert into Sell values(2,2,2);
insert into Sell values(3,3,3);
insert into Sell values(4,4,4);

select * from Sell;

insert into Grouped values(1,1);
insert into Grouped values(1,3);
insert into Grouped values(2,3);
insert into Grouped values(4,2);

select * from Grouped;

insert into Buy values(1,1,'2021-02-06',2);
insert into Buy values(2,2,'2021-02-07',3);
insert into Buy values(3,3,'2021-02-08',5);
insert into Buy values(4,4,'2021-02-09',4);
insert into Buy values(2,1,'2021-02-07',2);
insert into Buy values(1,2,'2021-02-11',5);

select * from Buy;
-- 2. Write a query to retrieve the most sold product per day in a specific location in the last week. You can pick the location of your choice.

select ProductName,LocationName from Product 
natural join Buy natural join Customer natural join Has natural join Location 
where LocationName='Suryapet' and 
DOP between '2021-02-06' and'2021-02-13' order by NoOfUnits desc limit 1;

-- 3. Write a query to list all the salesperson's details along with the count of products sold by them (if any) till the current date.

select SalesExecutiveID,SalesName,DOB,Mobile,sum(NoOfUnits)
from SalesExecutive natural join Sell natural join Buy group by SalesExecutiveID ;




