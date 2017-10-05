-- Derby database Setup.
-- Autoincrement replaced by GENERATED ALWAYS AS IDENTITY
-- (START WITH 1, INCREMENT BY 1) and null and not null removed.


create table abonne
(
	email varchar(25) ,
	noAbonne varchar(25) ,
	id_personne int  
		primary key,
	nbEmprunts int 
)
;

create table auteur
(
	alias varchar(25) ,
	id_personne int
		primary key
)
;

create table collection
(
	id_collection int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1)
		primary key,
	nom varchar(50) 
)
;

create table ecrit
(
	ISBN varchar(50)  ,
	id_personne int  ,
	primary key (ISBN, id_personne)
)
;

create index FK_ecrit_id_personne
	on ecrit (id_personne)
;

create table exemplaire
(
	id_exemplaire int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1)
		primary key,
	disponible boolean,
	ISBN varchar(50) ,
	id_historique int 
)
;

create index FK_Exemplaire_id_historique
	on exemplaire (id_historique)
;

create index FK_Exemplaire_ISBN
	on exemplaire (ISBN)

;

create table historique
(
	id_historique int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1)
		primary key,
	date_emp date ,
	date_ret date ,
	id_personne int ,
	id_exemplaire int ,
	constraint FK_Historique_id_exemplaire
		foreign key (id_exemplaire) references exemplaire (id_exemplaire)
)
;

create index FK_Historique_id_exemplaire
	on historique (id_exemplaire)
;

create index FK_Historique_id_personne
	on historique (id_personne)
;

alter table exemplaire
	add constraint FK_Exemplaire_id_historique
		foreign key (id_historique) references historique (id_historique)
;

create table livre
(
	ISBN varchar(50)  
		primary key,
	titre varchar(25)  ,
	sous_titre varchar(50) ,
	disponible boolean ,
	id_collection int ,
	constraint FK_Livre_id_collection
		foreign key (id_collection) references collection (id_collection)
)
;

create index FK_Livre_id_collection
	on livre (id_collection)
;

alter table ecrit
	add constraint FK_ecrit_ISBN
		foreign key (ISBN) references livre (ISBN)
;

alter table exemplaire
	add constraint FK_Exemplaire_ISBN
		foreign key (ISBN) references livre (ISBN)
;

create table personnes
(
	id_personne int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1)
		primary key,
	prenom varchar(50) ,
	nom varchar(25) ,
	date_naissance date 
)
;

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

