/*Создать отношения между пиццами и ингредиентами, пиццами и заказами.*/
CREATE TABLE pizza_Component (
  pizzaid     INT REFERENCES pizza (id),
  componentid INT REFERENCES component (id)
);

CREATE TABLE pizza_orders (
  pizzaid INT REFERENCES pizza (id),
  orderid INT REFERENCES orders (id)
);

INSERT INTO pizza values(1,'Margarita', 'tasty');