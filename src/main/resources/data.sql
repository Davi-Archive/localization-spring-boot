CREATE TABLE  tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
    );

INSERT INTO tb_cidade
    (id_cidade, nome, qtd_habitantes)
VALUES
    (1, 'São Paulo', 12395372),
    (2, 'Rio de Janeiro', 1000000);