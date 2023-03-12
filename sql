CREATE DATABASE if not exists superhero;
USE superhero;

drop table if exists superpower;
drop table if exists city;
drop table if exists superheroes;

create table superheroes(
hero_ID int,
heroname varchar(50),
realname varchar(50),
creationyear int,
PRIMARY KEY (heroname)
);

create table superpower(
superpowername varchar(30),
heroname varchar(50),
primary key (superpowername),
foreign key (heroname) references superheroes(heroname)
);

create table city(
cityname varchar(50),
heroname varchar(50),
foreign key (heroname) references superheroes(heroname)
);

insert into  superheroes values
  ('1', 'spiderman', 'peter parker', '1962');
insert into  superheroes values
  ('3', 'ironman', 'tony stark', '1963');
insert into superheroes values
  ('2', 'batman', 'bruce wayne', '1939');
insert into superheroes values
  ('4', 'superman', 'clark kent', '1938');
insert into superheroes values
  ('6', 'wonder woman', 'diana prince', '1941');
insert into superheroes values
  ('5', 'captain america', 'steve rogers', '1941');
insert into superheroes values
  ('7', 'hulk', 'bruce banner', '1962');
insert into superheroes values
  ('8', 'thor', 'thor odinson', '1962');

insert into superpower values
	('webshooting', 'spiderman');
insert into superpower values
	('energy projection', 'ironman');
insert into superpower values
	('detective skills', 'batman');
insert into superpower values
	('super strength', 'superman');
insert into superpower values
	('superhuman strength', 'wonder woman');
insert into superpower values
	('vibranium shield', 'captain america');
insert into superpower values
	('increased durability', 'hulk');
insert into superpower values
	('Mjolnir', 'thor');

insert into city values
	('Brooklyn', 'spiderman');
insert into city values
	('New York City', 'ironman');
insert into city values
	('Gotham City', 'batman');
insert into city values
	('Metropolis', 'superman');
insert into city values
	('Themyscira', 'wonder woman');
insert into city values
	('New York City', 'captain america');
insert into city values
	('New York City', 'hulk');
insert into city values
	('Asgard', 'thor');

/*opgave 3*/

SELECT COUNT(*) AS num_superheroes FROM superheroes;
SELECT heroname, realname, creationyear FROM superheroes ORDER BY creationyear DESC;
SELECT heroname, realname FROM superheroes WHERE creationyear = (SELECT MIN(creationyear) FROM superheroes);
SELECT heroname, creationyear FROM superheroes WHERE creationyear > 1960;
SELECT s.heroname, COUNT(*) AS num_superpowers FROM superheroes s JOIN superpower sp ON s.heroname = sp.heroname GROUP BY s.heroname;
SELECT s.heroname, COUNT(*) AS num_superpowers FROM superheroes s JOIN superpower sp ON s.heroname = sp.heroname GROUP BY s.heroname HAVING COUNT(*) > 1;
SELECT s.heroname, s.realname, GROUP_CONCAT(sp.superpowername) AS superpowers FROM superheroes s LEFT JOIN superpower sp ON s.heroname = sp.heroname GROUP BY s.heroname;
SELECT cityname FROM city ORDER BY cityname ASC;
SELECT cityname FROM city WHERE cityname LIKE 'N%';
SELECT superheroes.heroname, city.cityname FROM superheroes JOIN city ON superheroes.heroname = city.heroname;
SELECT COUNT(*) FROM city WHERE cityname = 'New York City';
SELECT DISTINCT city.cityname FROM city JOIN superheroes ON city.heroname = superheroes.heroname WHERE superheroes.heroname LIKE '%a%';