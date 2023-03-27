-- 1. Clear out old orders
DELETE FROM Orders WHERE CustomerID >= 92;

-- 2. Clear out old customers
DELETE FROM Customers WHERE CustomerID >= 92;

-- 3. Insert test customers
insert into Customers (CustomerName, ContactName, Address, City, PostalCode, Country) values ('Wilfrid Burress', 'Gayle Roft', '34 Jenifer Park', 'Zakliczyn', '32-840', 'Poland');
insert into Customers (CustomerName, ContactName, Address, City, PostalCode, Country) values ('Aloise Ruby', 'Moishe Glenwright', '88376 Kropf Pass', 'Wuyang', null, 'China');
insert into Customers (CustomerName, ContactName, Address, City, PostalCode, Country) values ('Cristobal Bramer', 'Sandra Elliman', '1 Delaware Plaza', 'Drosáto', null, 'Greece');
insert into Customers (CustomerName, ContactName, Address, City, PostalCode, Country) values ('Saloma Ferenczy', 'Joan Stormouth', '1791 Grim Drive', 'Yablonovskiy', '385141', 'Russia');
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country) values ('Tami Hune', 'Clemence Sporgeon', '61374 Arkansas Alley', 'El Mirador', '93429', 'Mexico');

-- 4. Update employee pictures
UPDATE Employees SET Photo = '';