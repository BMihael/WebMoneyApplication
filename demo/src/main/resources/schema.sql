create table if not exists users (
   id identity,
   username varchar(255) not null,
   password varchar(255) not null,
   enabled int not null
);

create table if not exists authorities (
   id identity,
   username varchar(255) not null,
   authority varchar(255) not null
);

create table if not exists novcanik (
   id identity,
   datum_upisa timestamp not null,
   naziv_Novcanika varchar(255) not null,
   tip varchar(255) not null,
   user varchar(255),
   PRIMARY KEY(id)
);

create table if not exists trosak (
   id identity,
   datum_Upisa timestamp not null,
   naziv varchar(255) not null,
   iznos double(11) not null,
   vrsta varchar(255) not null,
   id_novcanik int,
   PRIMARY KEY(id),
   FOREIGN KEY(id_novcanik) REFERENCES novcanik(id)
);

