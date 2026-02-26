
    create table alimentazioni (
        id integer not null auto_increment,
        alimentazione varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table bici (
        id integer not null,
        id_tipo_freno integer not null,
        id_tipo_sospensione integer not null,
        numero_marce integer not null,
        pieghevole bit not null,
        primary key (id)
    ) engine=InnoDB;

    create table categorie (
        id_categoria integer not null auto_increment,
        categoria varchar(50) not null,
        primary key (id_categoria)
    ) engine=InnoDB;

    create table colori (
        id_colore integer not null auto_increment,
        colore varchar(255),
        primary key (id_colore)
    ) engine=InnoDB;

    create table freni (
        id integer not null auto_increment,
        tipo varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table macchine (
        cilindrata integer not null,
        id integer not null,
        numero_porte integer not null,
        targa varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table marche (
        id_marca integer not null auto_increment,
        marca varchar(255) not null,
        primary key (id_marca)
    ) engine=InnoDB;

    create table messaggi_systema (
        lang varchar(4) not null,
        code varchar(20) not null,
        messaggio varchar(255),
        primary key (lang, code)
    ) engine=InnoDB;

    create table moto (
        cilindrata integer not null,
        id integer not null,
        targa varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table sospensioni (
        id_sospensione integer not null auto_increment,
        sospensione varchar(255) not null,
        primary key (id_sospensione)
    ) engine=InnoDB;

    create table tipi_veicolo (
        id_tipo_veicolo integer not null auto_increment,
        veicolo varchar(50) not null,
        primary key (id_tipo_veicolo)
    ) engine=InnoDB;

    create table veicoli (
        anno_produzione date not null,
        id integer not null auto_increment,
        id_categoria integer not null,
        id_colore integer not null,
        id_marca integer not null,
        id_tipo_alimentazione integer not null,
        id_tipo_veicolo integer not null,
        numero_ruote integer not null,
        modello varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table alimentazioni 
       add constraint UKkiugjsbx43ixcra9f6935kah5 unique (alimentazione);

    alter table freni 
       add constraint UK635mpdjok2tgk9d780hs54mk9 unique (tipo);

    alter table macchine 
       add constraint UKgxt0l1uuapmsn7rybuq808dsr unique (targa);

    alter table bici 
       add constraint FKlvo5f3hpqqwcrhw1ca6reeak6 
       foreign key (id_tipo_sospensione) 
       references sospensioni (id_sospensione);

    alter table bici 
       add constraint FK4srh5s7l1jfus7vr69jdp8ufo 
       foreign key (id_tipo_freno) 
       references freni (id);

    alter table bici 
       add constraint FKra4pq79y6t94qnygjmhto1d2f 
       foreign key (id) 
       references veicoli (id);

    alter table macchine 
       add constraint FKqttmt8yqk5vj8g3tn94ovrbay 
       foreign key (id) 
       references veicoli (id);

    alter table moto 
       add constraint FKt01inn1jct6p6irfuar0pt15d 
       foreign key (id) 
       references veicoli (id);

    alter table veicoli 
       add constraint FKm1py6cohh4bwr6l6oa6x9wjqs 
       foreign key (id_tipo_alimentazione) 
       references alimentazioni (id);

    alter table veicoli 
       add constraint FKfnj6d8ledmyr1pj05o2aunbga 
       foreign key (id_categoria) 
       references categorie (id_categoria);

    alter table veicoli 
       add constraint FK9fby65ukehcfx0sd0pmaewyry 
       foreign key (id_colore) 
       references colori (id_colore);

    alter table veicoli 
       add constraint FKiv5idk7drutlxyxhc5663nwey 
       foreign key (id_marca) 
       references marche (id_marca);

    alter table veicoli 
       add constraint FK7qfysarccvm8q0htrllh35wq0 
       foreign key (id_tipo_veicolo) 
       references tipi_veicolo (id_tipo_veicolo);
