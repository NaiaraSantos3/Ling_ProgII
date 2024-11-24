Insert Into Banco (idbanco, cnpjBanco,codigoBanco,nomeBanco)values
                                                       (1, '12.345.678/0001-99', '001', 'Banco do Brasil'),
                                                       (2, '98.765.432/0001-11', '033', 'Santander'),
                                                       (3, '01.234.567/0001-88', '104', 'Caixa Econômica Federal'),
                                                       (4, '11.223.344/0001-55', '237', 'Bradesco'),
                                                       (5, '22.334.455/0001-77', '341', 'Itaú');

INSERT INTO Cliente (idcliente,cpf, nomecliente, data_nascimento_cliente) VALUES
    ('1','12345678901', 'João Silva', '1990-01-01'),
    ('2','98765432100', 'Maria Oliveira', '1985-07-15'),
    ('3','11122334499', 'Carlos Pereira', '1988-11-22'),
    ('4','22233445566', 'Ana Souza', '1995-02-17');

-- Inserindo dados na tabela LEILAO
INSERT INTO leilao (id_Leilao,data_abertura_leilao, data_encerramento_leilao,
                    data_visita_produto, cidade_leilao, endereco_fisico_leilao, estado_leilao, site_leilao) VALUES
                                                                                                                ('1','2024-03-01 10:00:00', '2024-03-10 18:00:00', '2024-03-05 14:00:00', 'São Paulo', 'Rua A, 100', 'SP', 'www.leilao1.com.br'),
                                                                                                                ('2','2024-04-01 10:00:00', '2024-04-10 18:00:00', '2024-04-05 14:00:00', 'Rio de Janeiro', 'Rua B, 200', 'RJ', 'www.leilao2.com.br'),
                                                                                                                ('3','2024-05-01 10:00:00', '2024-05-10 18:00:00', '2024-05-05 14:00:00', 'Belo Horizonte', 'Rua C, 300', 'MG', 'www.leilao3.com.br');

INSERT INTO produto (id_produto, leilao_id_leilao, valor_inicial_produto, descricao_produto, nome_produto, sub_categoria_produto) VALUES
    (1, 1, 1500.0, 'Notebook Dell Inspiron 15', 'Notebook Dell', 'NOTEBOOK'),
    (2, 1, 800.0, 'Monitor Samsung 24 polegadas', 'Monitor Samsung', 'MONITOR'),
    (3, 1, 250.0, 'Hub USB 4 portas', 'Hub USB', 'HUB'),
    (4, 1, 450.0, 'Switch de 8 portas Gigabit', 'Switch Gigabit', 'SWITCH'),
    (5, 1, 300.0, 'Roteador Wi-Fi AC1200', 'Roteador AC1200', 'ROTEADOR'),
    (6, 2, 25000.0, 'Carro de passeio Honda Civic 2018', 'Honda Civic', 'CARRO'),
    (7, 2, 18000.0, 'Motocicleta Yamaha Fazer 250', 'Yamaha Fazer', 'MOTO'),
    (8, 2, 40000.0, 'Caminhão Volkswagen Constellation 2020', 'Volkswagen Constellation', 'CAMINHAO'),
    (9, 2, 15000.0, 'Veículo utilitário Fiat Fiorino', 'Fiat Fiorino', 'UTILITARIO');

-- Inserindo dados na tabela LANCE
INSERT INTO lance (cliente_idcliente, idlance, lance_id_produto, produto_id_produto, valorlance)
VALUES
    (1, 1, 1, 1, 550.0),  -- Cliente 1 (João Silva) deu lance de 550 no Produto 1
    (2, 2, 2, 2, 1200.0), -- Cliente 2 (Maria Oliveira) deu lance de 1200 no Produto 2
    (3, 3, 3, 3, 800.0),  -- Cliente 3 (Carlos Pereira) deu lance de 800 no Produto 3
    (4, 4, 4, 4, 300.0);  -- Cliente 4 (Ana Souza) deu lance de 300 no Produto 4


-- Inserindo dados na tabela BANCO_LEILAO
INSERT INTO banco_leilao (idbanco, idleilao) VALUES
                                                 (1, 1),  -- Banco do Brasil associado ao Leilão 1
                                                 (2, 1),  -- Santander associado ao Leilão 1
                                                 (3, 2),  -- Caixa Econômica Federal associado ao Leilão 2
                                                 (4, 3),  -- Bradesco associado ao Leilão 3
                                                 (5, 2);  -- Itaú associado ao Leilão 2


-- Inserindo dados na tabela LEILAO_BANCO
INSERT INTO leilao_banco (id_banco, id_leilao) VALUES
                                                   (1, 1),  -- Banco do Brasil associado ao Leilão 1
                                                   (2, 1),  -- Santander associado ao Leilão 1
                                                   (3, 2),  -- Caixa Econômica Federal associado ao Leilão 2
                                                   (4, 3),  -- Bradesco associado ao Leilão 3
                                                   (5, 2);  -- Itaú associado ao Leilão 2
