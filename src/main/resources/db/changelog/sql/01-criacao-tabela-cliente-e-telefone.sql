--liquibase formatted sql
--changeset renderson.junior:criacao-de-tabela-cliente
create table public.cliente(
    id int AUTO_INCREMENT primary key,
    nome varchar(100) unique,
    cpf varchar(11) unique,
    endereco varchar(100),
    bairro varchar(50)
);

--changeset renderson.junior:criacao-de-tabela-telefone
create table public.telefone(
    id int AUTO_INCREMENT primary key,
    numero varchar(20),
    id_cliente int,
    foreign key (id_cliente) references cliente(id)
);

