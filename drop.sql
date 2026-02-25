
    alter table bici 
       drop 
       foreign key FKlvo5f3hpqqwcrhw1ca6reeak6;

    alter table bici 
       drop 
       foreign key FK4srh5s7l1jfus7vr69jdp8ufo;

    alter table bici 
       drop 
       foreign key FKra4pq79y6t94qnygjmhto1d2f;

    alter table macchine 
       drop 
       foreign key FKqttmt8yqk5vj8g3tn94ovrbay;

    alter table moto 
       drop 
       foreign key FKt01inn1jct6p6irfuar0pt15d;

    alter table veicoli 
       drop 
       foreign key FKm1py6cohh4bwr6l6oa6x9wjqs;

    alter table veicoli 
       drop 
       foreign key FKfnj6d8ledmyr1pj05o2aunbga;

    alter table veicoli 
       drop 
       foreign key FK9fby65ukehcfx0sd0pmaewyry;

    alter table veicoli 
       drop 
       foreign key FKiv5idk7drutlxyxhc5663nwey;

    alter table veicoli 
       drop 
       foreign key FK7qfysarccvm8q0htrllh35wq0;

    drop table if exists alimentazioni;

    drop table if exists bici;

    drop table if exists categorie;

    drop table if exists colori;

    drop table if exists freni;

    drop table if exists macchine;

    drop table if exists marche;

    drop table if exists messaggi_systema;

    drop table if exists moto;

    drop table if exists sospensioni;

    drop table if exists tipi_veicolo;

    drop table if exists veicoli;
