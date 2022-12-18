CREATE TABLE  tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
    );

INSERT INTO tb_cidade
    (id_cidade, nome, qtd_habitantes)
VALUES
    (1, 'São Paulo', 12395372),
    (2, 'Rio de Janeiro', 1000000),
    (3, 'Fortaleza', 8000000),
    (4, 'Salvador', 6000000),
    (5, 'Belo Horizonte', 1000000),
    (6, 'Porto Alegre', 1000000),
    (7, 'Porto Velho', 105555000),
    (8, 'Palmas', 132312000),
    (9, 'Recife', 1534534530),
    (10, 'Natal', 1534534530),
    (11, 'Brasilia', 1534534530);