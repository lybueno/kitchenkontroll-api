insert into addon (id, addon_type, name, price) values (1, 0, 'Cheddar', 5.99);
insert into addon (id, addon_type, name, price) values (2, 0, 'Catupiry', 5.99);
insert into addon (id, addon_type, name, price) values (3, 0, 'Mussarela', 5.99);
insert into addon (id, addon_type, name, price) values (4, 0, 'None', 0.0);


INSERT INTO tb_table(id) VALUES (1);
INSERT INTO tb_table(id) VALUES (2);
INSERT INTO tb_table(id) VALUES (3);


INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (1, 0, 'Calabresa', 'descrição', 30.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (2, 0, 'Mussarela', 'descrição', 30.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (3, 0, 'Strogonoff', 'descrição', 30.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (4, 0, 'Rúcula', 'descrição', 30.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (5, 0, 'Costelinha com Mostarda e Mel', 'descrição', 30.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (6, 0, 'Quatro Queijos', 'descrição', 30.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (7, 1, 'Coca Cola', 'descrição', 5.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (8, 1, 'Doly', 'descrição', 5.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (9, 1, 'Guaraná', 'descrição', 5.0, 'urlImagem');
INSERT INTO item_cardapio(id, item_type, name, description, base_price, img_url) VALUES (10, 1, 'Água', 'descrição', 3.0, 'urlImagem');


INSERT INTO size(id, size, multiplier) VALUES (1, 2, 2);
INSERT INTO size(id, size, multiplier) VALUES (2, 1 , 1);
INSERT INTO size(id, size, multiplier) VALUES (3, 0, 0.5);

INSERT INTO drink(id, price, table_id, status, item_cardapio_id, delivery_preference) VALUES(1, 5.99, 1, 0, 7, true);
INSERT INTO drink(id, price, table_id, status, item_cardapio_id, delivery_preference) VALUES(2, 5.99, 1, 0, 8, false);
INSERT INTO drink(id, price, table_id, status, item_cardapio_id, delivery_preference) VALUES(3, 5.99, 1, 0, 9, true);

INSERT INTO pizza(id, price, table_id, status, size_id) VALUES(1, 60, 1, 0, 1);
INSERT INTO pizza(id, price, table_id, status, size_id) VALUES(2, 60, 1, 0, 2);
INSERT INTO pizza(id, price, table_id, status, size_id) VALUES(3, 60, 1, 0, 3);
INSERT INTO pizza(id, price, table_id, status, size_id) VALUES(4, 60, 2, 0, 1);

INSERT INTO ADDONS_PIZZA(ADDON_ID, PIZZA_ID) VALUES(1, 1);
INSERT INTO ADDONS_PIZZA(ADDON_ID, PIZZA_ID) VALUES(1, 2);
INSERT INTO ADDONS_PIZZA(ADDON_ID, PIZZA_ID) VALUES(2, 3);
INSERT INTO ADDONS_PIZZA(ADDON_ID, PIZZA_ID) VALUES(4, 4);

INSERT INTO PIZZAS_ITEM_CARDAPIO(PIZZA_ID, ITEM_CARDAPIO_ID) VALUES(1, 1);
INSERT INTO PIZZAS_ITEM_CARDAPIO(PIZZA_ID, ITEM_CARDAPIO_ID) VALUES(1, 2);
INSERT INTO PIZZAS_ITEM_CARDAPIO(PIZZA_ID, ITEM_CARDAPIO_ID) VALUES(2, 3);
INSERT INTO PIZZAS_ITEM_CARDAPIO(PIZZA_ID, ITEM_CARDAPIO_ID) VALUES(3, 5);
INSERT INTO PIZZAS_ITEM_CARDAPIO(PIZZA_ID, ITEM_CARDAPIO_ID) VALUES(4, 1);
INSERT INTO PIZZAS_ITEM_CARDAPIO(PIZZA_ID, ITEM_CARDAPIO_ID) VALUES(4, 3);