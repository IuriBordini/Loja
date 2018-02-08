create database if not exists loja;
use loja;
create table produto(
    id int primary key auto_increment,
    nome varchar(255) not null,
    preco float not null,
    descricao varchar(255) not null
);
insert into produto values
    (default,'Computador', 2000, 'Core i5 8GB'),
    (default,'Impressora', 800, 'Multifuncional'),
    (default,'Mouse', 20, 'USB');
create table usuario {

nome varchar(255) not null,
senha varchar(255) not null)
}
insert into usuario values('admin,123');