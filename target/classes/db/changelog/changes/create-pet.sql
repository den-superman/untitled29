--liquibase formatted sql
--changeset denis:create-pet splitStatements:true endDelimiter:;
create table pets (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
insert into `pets` values (1, 'bobik');

--rollback DROP TABLE pets;
