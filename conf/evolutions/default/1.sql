# --- !Ups

create table message (
  id                        integer not null,
  author_name               varchar(255),
  create_time               timestamp,
  localisation_longitude    float,
  localisation_latitude     float,
  text                      varchar(255),
  constraint pk_message primary key (id))
;

create sequence test_sequence;




# --- !Downs

drop table if exists message cascade;

drop sequence if exists test_sequence;

