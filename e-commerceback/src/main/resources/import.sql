insert into categoria (nome, descricao) values ('Informática', 'Produtos de Informática');
insert into categoria (nome, descricao) values ('Livros', 'Livros Técnicos');
insert into categoria (nome, descricao) values ('Móveis','Móveis decorativos');
insert into categoria (nome, descricao) values ('Ferramentas','Ferramentas gerais');
insert into categoria (nome, descricao) values ('Papelaria','Itens de escritório');

insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Código Limpo', 'Livro do Autor Robert C. Martin', 87.34, 45, 3);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Fone de Ouvido','Fone de Ouvido', 34.49, 67, 1);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Cadeira de Escritório', 'Cadeira de Escritório preta', 34, 36, 4);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Chave Inglesa', 'Chave inglesa', 14, 76, 5);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Frigideira', 'Frigideira futon', 25.39, 46, 4);

insert into cliente (nome, email, telefone) values ('João Silva', 'joao.silva@email.com', '14998123456');
insert into cliente (nome, email, telefone) values ('Maria Oliveira', 'maria.oliveira@email.com', '14998234567');
insert into cliente (nome, email, telefone) values ('Carlos Souza', 'carlos.souza@email.com', '14998345678');
insert into cliente (nome, email, telefone) values ('Ana Pereira', 'ana.pereira@email.com', '14998456789');
insert into cliente (nome, email, telefone) values ('Lucas Santos', 'lucas.santos@email.com', '14998567890');

insert into pedido (`data`, status, valor_total, cliente_id) values ('2026-09-01', 'PENDENTE', 87.34, 1);
insert into pedido (`data`, status, valor_total, cliente_id) values ('2026-09-02', 'PAGO', 68.98, 2);
insert into pedido (`data`, status, valor_total, cliente_id) values ('2026-09-02', 'EM_PROCESSAMENTO', 102.00, 3);
insert into pedido (`data`, status, valor_total, cliente_id) values ('2026-09-03', 'ENVIADO', 14.00, 4);
insert into pedido (`data`, status, valor_total, cliente_id) values ('2026-09-03', 'ENTREGUE', 25.39, 5);

insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 87.34, 1, 1);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (2, 34.49, 2, 2);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (3, 34.00, 3, 3);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 14.00, 4, 4);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 25.39, 5, 4);

insert into pagamento (valor, `data`, status, tipo, pedido_id) values (87.34, '2026-09-01', 'PENDENTE', 'PIX', 1);
insert into pagamento (valor, `data`, status, tipo, pedido_id) values (68.98, '2026-09-02', 'APROVADO', 'CARTAO_CREDITO', 2);
insert into pagamento (valor, `data`, status, tipo, pedido_id) values (102.00, '2026-09-02', 'APROVADO', 'BOLETO', 3);
insert into pagamento (valor, `data`, status, tipo, pedido_id) values (14.00, '2026-09-03', 'APROVADO', 'PIX', 4);
insert into pagamento (valor, `data`, status, tipo, pedido_id) values (25.39, '2026-09-03', 'APROVADO', 'CARTAO_DEBITO', 5);