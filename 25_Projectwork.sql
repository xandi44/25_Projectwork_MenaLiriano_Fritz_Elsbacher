DROP TABLE country CASCADE CONSTRAINTS;
DROP TABLE city CASCADE CONSTRAINTS;
DROP TABLE picture CASCADE CONSTRAINTS;

CREATE TABLE country(
    id integer GENERATED ALWAYS AS IDENTITY ,
    name CHAR(200),
    PRIMARY KEY (id)
);

CREATE TABLE city(
    id integer GENERATED ALWAYS AS IDENTITY ,
    name CHAR(200),
    idCountry INTEGER,
    einwohner INTEGER,
    flaeche INTEGER,
    seehoehe INTEGER,
    webseite CHAR(200),
    PRIMARY KEY (id),
    FOREIGN KEY (idCountry) REFERENCES country(id)
);

CREATE TABLE picture(
    id integer GENERATED ALWAYS AS IDENTITY,
    idCity INTEGER,
    picture blob,
    FOREIGN KEY (idCity) REFERENCES city(id)
);


--England
INSERT INTO country (name) VALUES ('England');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Brighton',1,229700,82.79,10,'https://www.visitbrighton.com/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Liverpool',1,496784,111.8,70,'https://www.visitliverpool.com/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('London',1,8982000,1572,11,'https://www.visitlondon.com/');

--Frankreich
INSERT INTO country (name) VALUES ('Frankreich');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Lyon',2,513275,47.87,202,'https://www.visiterlyon.com/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Paris',2,2161000,105.4,35,'https://www.parisinfo.com/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Toulouse',2,471941,118.3,146,'https://www.parisinfo.com/');

--Italien
INSERT INTO country (name) VALUES ('Italien');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Florenz',3,382258,102.4,50,'https://www.destinationflorence.com/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Rom',3,2873000,1285,37,'https://www.turismoroma.it/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Venedig',3,261905,414.6,1,'https://www.veneziaunica.it/');

--Oesterreich
INSERT INTO country (name) VALUES ('Oesterreich');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Klagenfurt',4,287528,120.1,446,'https://www.visitklagenfurt.at/de/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Salzburg',4,153367,65.68,424,'https://www.salzburg.info/de');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Wien',4,1897000,414.6,250,'https://www.wien.info/de');

--Schweiz
INSERT INTO country (name) VALUES ('Schweiz');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Bern',5,133115,51.6,540,'https://www.bern.com/de/home');
--INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('St. Moritz',5,5233,28.69,1882,'https://www.stmoritz.com/de/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Z�rich',5,402762,87.88,408,'https://www.zuerich.com/de');

--Spanien
INSERT INTO country (name) VALUES ('Spanien');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Barcelona',6,162000,101.9,12,'https://www.barcelona.com/es/guia_ciudad');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Madrid',6,3223000,604.3,667,'https://www.esmadrid.com/');
INSERT INTO city (name, idCountry,einwohner,flaeche,seehoehe,webseite) VALUES ('Mallorca',6,409661,208.6,13,'https://www.bierkoenig.com/');

COMMIT;