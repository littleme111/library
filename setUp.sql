-- Run this sql script to set up project.
create table abonne(
	email varchar(25) null,
	noAbonne varchar(25) null,
	id_personne int not null primary key,
	nbEmprunts int null);

create table auteur(
	alias varchar(25) null,
	id_personne int not null primary key);

create table collection(
	id_collection int auto_increment primary key,
	nom varchar(50) null);

create table ecrit(
	ISBN varchar(50) not null,
	id_personne int not null,
	primary key (ISBN, id_personne));

create index FK_ecrit_id_personne
	on ecrit (id_personne);

create table exemplaire(
	id_exemplaire int auto_increment primary key,
	disponible tinyint(1) null,
	ISBN varchar(50) null,
	id_historique int null);

create index FK_Exemplaire_id_historique
	on exemplaire (id_historique);

create index FK_Exemplaire_ISBN
	on exemplaire (ISBN);

create table historique(
	id_historique int auto_increment
		primary key,
	date_emp date null,
	date_ret date null,
	id_personne int null,
	id_exemplaire int null,
	constraint FK_Historique_id_exemplaire
		foreign key (id_exemplaire) references exemplaire (id_exemplaire));

create index FK_Historique_id_exemplaire
	on historique (id_exemplaire);

create index FK_Historique_id_personne
	on historique (id_personne);

alter table exemplaire
	add constraint FK_Exemplaire_id_historique
		foreign key (id_historique) references historique (id_historique);

create table livre(
	ISBN varchar(50) not null
		primary key,
	titre varchar(25) not null,
	sous_titre varchar(50) null,
	disponible tinyint(1) null,
	id_collection int null,
	constraint FK_Livre_id_collection
		foreign key (id_collection) references collection (id_collection));

create index FK_Livre_id_collection
	on livre (id_collection);

alter table ecrit
	add constraint FK_ecrit_ISBN
		foreign key (ISBN) references livre (ISBN);

alter table exemplaire
	add constraint FK_Exemplaire_ISBN
		foreign key (ISBN) references livre (ISBN);

create table personnes(
	id_personne int auto_increment
		primary key,
	prenom varchar(50) null,
	nom varchar(25) null,
	date_naissance date null);

alter table abonne
	add constraint FK_Abonne_id_personne
		foreign key (id_personne) references personnes (id_personne)
;

alter table auteur
	add constraint FK_Auteur_id_personne
		foreign key (id_personne) references personnes (id_personne)
;

alter table ecrit
	add constraint FK_ecrit_id_personne
		foreign key (id_personne) references personnes (id_personne)
;

alter table historique
	add constraint FK_Historique_id_personne
		foreign key (id_personne) references personnes (id_personne)
;

