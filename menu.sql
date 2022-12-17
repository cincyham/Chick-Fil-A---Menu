
DROP TABLE IF EXISTS public.transaction_item, public.transaction,  public.item;
DROP SEQUENCE IF EXISTS seq_item_id, seq_transaction_id, seq_transaction_item_id;




CREATE TABLE public.item(
	item_id serial NOT NULL PRIMARY KEY,
	item_name varchar(50) UNIQUE NOT NULL,
	calories int NOT NULL,
	item_type varchar(30) NOT NULL,
	price int NOT NULL,
	CONSTRAINT chk_item_type CHECK (item_type IN ('Entree', 'Salad', 'Drink', 'Treat'))
);

CREATE TABLE public.transaction(
	transaction_id serial NOT NULL PRIMARY KEY,
	transaction_date date NOT NULL,
	total numeric (9,2) NOT NULL
);


CREATE TABLE public.transaction_item(
	transaction_item_id serial NOT NULL PRIMARY KEY,
	item_id int NOT NULL,
	transaction_id int NOT NULL,
	CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES item (item_id),
	CONSTRAINT fk_transaction_id FOREIGN KEY (transaction_id) REFERENCES transaction (transaction_id)
);