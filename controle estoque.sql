/**
*Projeto 2: Controle de estoque
Versão 1.0
* @author Paloma Kimberly Figueredo
*/

show databases;
show tables;

create database dbconest;
use dbconest;

/*
Formatando e realizando operações no banco de dados
Unique = Impede valores duplicados no campo da tabela
timestamp default current_timestamp = data/hota automático
date = Data no formato (YYYYMMDD)
decimal(10,2) = Digitos, casas decimais) Tipo numérico real
insert de numero inteiro não usa aspas simples
Usar ponto para numero no insert
sum () = soma
datediff(data1,data2) = 
curdate() = data atual
*/

create table estoque(
codigo int primary key auto_increment,
barcode varchar(50) unique,
produto varchar (100) not null,
fabricante varchar (100) not null,
datacad timestamp default current_timestamp,
dataval date not null,
quantidade int not null,
estoquemin int not null,
medida varchar(50) not null,
valor  decimal(10,2),
localizacao varchar(100)

);

describe estoque;

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao)
values ('87654321','Régua 30cm','Faber Castel',20230531,70,10,'unidade',3.99,'Setor E');

select * from estoque;

-- executando operações matemáticas no select (inventário)
select sum(valor * quantidade) as Total from estoque;

-- formatando data/hora e mudando os nomes dos campos(apelidos)
/* 
Formatar data usamos a função  date_format
date_format(campo,formato)
Formato '%d%m%y' (dia, mês e ano com 2 digitos)
Formato '%d%m%Y' (dia, mês e ano com 4 digitos)
*/

select codigo as código, barcode, produto, fabricante, date_format(datacad,'%d%m%Y') as data_cadastro, dataval as data_validade, quantidade, estoquemin as estoque_mínimo, medida, valor, localizacao as localização from estoque order by produto;

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao)
values('97654321','Caneta Esferográfica cx50','BIC','20220531',15,30,'caixa',17,'Setor B');

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao)
values('07654321','Caderno Universitário 200 folhas','Tilibra',20240508,100,10,'unidade',48.99,'Setor M');

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao)
values('33332222','Cola Branca 110g','Tenaz',20250819,10,17,'caixa',6.99,'Setor H');

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao)
values('55554444','Estojo Bart Simpsons','SIMPSONS',20301027,12,3,'unidade',19.99,'Setor I');

update estoque set quantidade='40' where codigo=4;

delete from estoque where codigo=10;

update estoque set dataval='' where codigo=3;

-- insert into estoque
-- (barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao)
-- values('12245699','Geleia Real','Abelha','',200,50,'unidade',15,'Setor L');

drop table estoque;

-- Relatório de reposição de estoque 1
select * from estoque where quantidade < estoquemin;

-- Relatório de reposição de estoque 2
select codigo as código,produto, date_format(dataval,'%d/%m/%Y') as data_validade, quantidade, 
estoquemin as estoque_mínimo from estoque where quantidade < estoquemin;

-- Relatório de controle de validade 1
select codigo,produto,date_format(dataval,'%d/%m/%Y') as validade from estoque;

-- Relatório de controle de validade 2



