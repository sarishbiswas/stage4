DROP SCHEMA IF EXISTS docker_db;
create schema docker_db;
use docker_db

create table movielist(id long,title varchar(120), boxoffice varchar(120),active boolean, dateoflaunch date,genre varchar(120), hasteaser boolean);


insert into movielist(id,title,boxoffice,active,dateoflaunch,genre,hasteaser)
values
(100,"You","123,1234,123",true,"2017-12-17","Thriller",true),
(101,"Breathe","123,1234,123",true,"2017-12-17","Suspense",true),
(102,"Notebook","123,1234,123",true,"2017-12-17","Romance",true),
(103,"Avtar","123,1234,123",true,"2017-12-17","Adventure",true),
(104,"Bates Motel","123,1234,123",true,"2017-12-17","Mystry",true);