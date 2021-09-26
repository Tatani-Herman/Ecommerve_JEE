create table users(
id int NOT NULL,
name varchar(255),
password varchar(255),
primary key(id));

create table categorie(
id int NOT NULL,
intitule varchar(255),
primary key (id));

create table produits(
id int NOT NULL,
nom varchar(255),
id_categorie int,
qte_disponible int,
prix int,
img_Link varchar(255),
primary key(id),
foreign key (id_categorie) references categorie(id));


create table commandes(
id int NOT NULL,
id_produit int,
id_user int,
qte int,
primary key (id),
foreign key (id_produit) references produits(id),
foreign key (id_user) references users(id));

Insert Into Categorie(id,intitule) Values
(1,'NUMERIQUE'),
(2,'SCOLAIRE'),
(3,'PRODUITS LAITIERS'),
(4,'HYGIENE'),
(5,'COSMETIQUE');


Insert into produits(id,nom,id_categorie,qte_disponible,prix,img_Link)
Values (1,'MacBookPro 16',1,10,2000,'Mac.jpg'),
(2,'ASUS PC',1,10,3000,'assus.jpg'),
(3,'Apple Watch',1,5,800,'apple.jpg'),
(4,'MATHEMATIQUES',2,10,100,'livre.jpg'),
(5,'PROGRAMMATION J2EE',2,10,200,'livre2.jpg'),
(6,'LIVRE SECURITE ET HACKING',2,10,200,'livre3.jpg'),
(7,'LAIT CAILLE',3,10,20,'lait.jpg'),
(8,'DANONE',3,10,20,'danone.jpg'),
(9,'FROMAGE',3,10,10,'fromage.jpg'),
(10,'PAPIER HYGIENIQUE',4,10,15,'papier.jpg'),
(11,'DESINFECTANT',4,10,17,'desinfect.jpg'),
(12,'OMO',4,10,3,'omo.jpg'),
(13,'Gel Douche NIVEA',5,10,15,'gel.jpg'),
(14,'PACK VAISSELLE',1,10,27,'vaisselle.jpg'),
(15,'Huile dArgan',5,10,55,'arg.jpg'),
(16,'Shampooing',5,10,47,'shamp.jpg');
