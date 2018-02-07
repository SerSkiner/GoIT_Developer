CREATE TABLE products
(id  varchar(36) primary key,
product_name varchar(50) not null,
manufacter_id varchar(36),
price decimal not null,
index (manufacter_id));

CREATE TABLE manufacturers
(id  varchar(36) primary key,
manufacter_name varchar(50) not null,
product_id varchar(36),
 FOREIGN KEY (product_id) REFERENCES products (id));






