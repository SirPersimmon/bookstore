INSERT INTO users (username, password, enabled, role) VALUES ('admin', '$2a$10$Ndd7tm.E0npPIyi2w4kYl.ExtGKxS9NXtfU6TnZX4ZgpHSQ3jnzXK', TRUE, 'ROLE_ADMIN');
INSERT INTO users (username, password, enabled, role) VALUES ('user', '$2a$10$RnVDpXh7/sJ2YXu1T4zCI.5FFvMMULG9RX4ibbwfzE7p97vWW0QMe', TRUE, 'ROLE_USER');

INSERT INTO books (isbn, author, title, price) VALUES ('978-1-84384-226-2', 'Norris J. Lacy', 'Lancelot-Grail', 125.00);
INSERT INTO books (isbn, author, title, price) VALUES ('978-1-61720-586-6', 'Chretien DeTroys', 'Four Arthurian Romances - Lancelot', 60.00);
INSERT INTO books (isbn, author, title, price) VALUES ('978-0-00848-553-5', 'Jessie Weston', 'Sir Gawain and the Green Knight', 100.00);
INSERT INTO books (isbn, author, title, price) VALUES ('978-5-04116-866-7', 'Дада Садананда; Виталий Лейбин', 'Диалоги о медитации', 30.00);
INSERT INTO books (isbn, author, title, price) VALUES ('978-5-75020-064-1', 'Стив Макконнелл', 'Совершенный код', 65.00);
INSERT INTO books (isbn, author, title, price) VALUES ('978-5-31800-492-6', 'Эндрю Таненбаум', 'Компьютерные сети', 105.00);

INSERT INTO receipts (number, date) VALUES ('00001', '2023-11-01');
INSERT INTO receipts (number, date) VALUES ('00002', '2023-11-02');
INSERT INTO receipts (number, date) VALUES ('00003', '2023-11-03');
INSERT INTO receipts (number, date) VALUES ('00005', '2023-11-04');
INSERT INTO receipts (number, date) VALUES ('00006', '2023-11-05');

INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (1, 1, 1, 2);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (1, 2, 2, 1);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (1, 3, 3, 1);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (2, 1, 6, 5);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (2, 2, 5, 7);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (2, 3, 4, 9);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (3, 1, 4, 10);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (4, 1, 3, 25);
INSERT INTO receipt_items (receipt_id, line_number, book_id, quantity) VALUES (5, 1, 1, 12);

INSERT INTO invoices (number, date, sum) VALUES ('00001', '2023-11-11', 170.00);
INSERT INTO invoices (number, date, sum) VALUES ('00002', '2023-11-12', 225.00);
INSERT INTO invoices (number, date, sum) VALUES ('00003', '2023-11-13', 30.00);
INSERT INTO invoices (number, date, sum) VALUES ('00005', '2023-11-14', 125.00);
INSERT INTO invoices (number, date, sum) VALUES ('00006', '2023-11-15', 120.00);

INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (1, 1, 6, 105.00, 1, 105.00);
INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (1, 2, 5, 65.00, 1, 65.00);
INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (2, 1, 1, 125.00, 1, 125.00);
INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (2, 2, 3, 100.00, 1, 100.00);
INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (3, 1, 4, 30.00, 1, 30.00);
INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (4, 1, 1, 125.00, 1, 125.00);
INSERT INTO invoice_items (invoice_id, line_number, book_id, price, quantity, sum) VALUES (5, 1, 2, 60.00, 2, 120);
