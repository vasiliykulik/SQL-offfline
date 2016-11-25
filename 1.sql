/*Создать таблицы Ингредиенты с полем - название,
 Пицца - название и цена,
Заказ с полями - ИД, время принятия заказы, адрес доставки, коментарии, телефон, емэйл, контактное лицо и комментарии.
*/

CREATE TABLE Component (
  id    INT PRIMARY KEY NOT NULL,
  name  VARCHAR(20),
  price REAL

);

CREATE TABLE pizza (
  id      INT PRIMARY KEY NOT NULL,
  name    VARCHAR(20),
  Comment VARCHAR(50)
);

CREATE TABLE ORDERs (
  id      INT PRIMARY KEY NOT NULL,
  time    TIMESTAMP,
  adress  VARCHAR(50),
  comment VARCHAR(50),
  phone   VARCHAR(20),
  email   VARCHAR(30),
  contact VARCHAR(30)
);






