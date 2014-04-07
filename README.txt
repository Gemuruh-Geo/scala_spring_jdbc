Query SQL

use springjdbc
go
create table Employee{
	ID int unsigned not null auto_increment,
	NAME varchar(256) not null,
	AGE int unsigned not null,
	primary key(ID)
}
go