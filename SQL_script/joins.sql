use company;

#creates an inner join between 'Customers' table and 'Orders' table
SELECT Customers.efternavn, orders.o_id, customers.adresse
FROM customers
INNER JOIN orders ON Orders.C_ID=Customers.id;

#creates a left join between 'Customers' table and 'Orders' table
SELECT Customers.efternavn, orders.o_id, customers.adresse
FROM customers
LEFT JOIN orders 
ON Orders.C_ID=Customers.id;

#creates a right join between 'Customers' table and 'Orders' table
SELECT Customers.efternavn, orders.o_id, customers.adresse
FROM customers
RIGHT JOIN orders 
ON Orders.C_ID=Customers.id;

#creates a full join between 'Customers' table and 'Orders' table using 'UNION' keyword
SELECT * FROM customers
LEFT JOIN orders 
ON orders.c_id=customers.id
UNION
SELECT * FROM customers
RIGHT JOIN orders 
ON orders.c_id=customers.id;

#creates a view - 'ordersview' - of order# - customer's first and last names
#between 'Orders' table and 'Customers' table
CREATE VIEW ordersview AS 
SELECT orders.orderNO, Customers.fornavn, Customers.efternavn
FROM company.orders, company.Customers
WHERE orders.c_id=customers.id;


#creates a view - 'view-orders' - of customer's last name - order id - customer's address
#between 'Customers' table and 'Orders' table
CREATE VIEW view_orders AS
SELECT customers.efternavn, orders.o_id, customers.adresse
FROM customers
LEFT JOIN orders
ON orders.c_id=customers.id;

#shows 'VIEW' - view-orders in ascending order
SELECT * FROM view_orders
ORDER BY efternavn ASC;