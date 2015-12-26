begin transaction;

drop table if exists department;
drop table if exists brown_rice;

create table department(
	depid text NOT NULL primary key,
	title text
);
insert into department values("1","Walmart");
insert into department values("2","Easy Foods");
insert into department values("3","No Frills");
insert into department values("4","Farmer Choice");
insert into department values("5","Bulk barn");
insert into department values("6","Canadian WholeSale Foods");
insert into department values("7","Neighbour Friendly");

create table brown_rice(
	id integer NOT NULL primary key,
	brand text,
	name text,
	type text,
	depid text,
	price integer,
	size integer,
	score integer
);
insert into brown_rice values(1001,"Best Rice","Best Rice Jasmine","Jasmine","1",5.50,4.50,7);
insert into brown_rice values(1002,"Easy Rice","Easy Rice Long Grain","Long Grain","4",2.50,3.50,5);
insert into brown_rice values(1003,"Uncle Ben Rice","Uncle Ben Basmati","Basmati","3",6.50,7.50,9);
insert into brown_rice values(1004,"Tilda Rice","Classic Basmati","Basmati","1",7.50,5.50,9.50);
insert into brown_rice values(1005,"Honey Rice","Classic Long grain", "Long Grain","1",3.50,3.4,6);
insert into brown_rice values(1006,"Best Choice Rice","Best Choice Short Grain","Short Grain","5",5.50,3,7.5);