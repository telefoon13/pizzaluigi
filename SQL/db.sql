CREATE USER cursist
  IDENTIFIED BY 'cursist';
GRANT ALL ON pizzaluigi.* TO cursist
INSERT INTO pizzas (naam, prijs, pikant) VALUES ("Prosciutto", 5, 0);
INSERT INTO pizzas (naam, prijs, pikant) VALUES ("Margagritta", 4, 0);
INSERT INTO pizzas (naam, prijs, pikant) VALUES ("Calzone", 5, 1);