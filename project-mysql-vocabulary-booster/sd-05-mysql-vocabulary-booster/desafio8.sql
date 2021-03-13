SELECT 
C.ContactName `Nome de contato`,
S.ShipperName `Empresa que fez o envio`,
O.OrderDate `Data do pedido`
FROM w3schools.orders AS O
INNER JOIN w3schools.customers AS C
ON O.CustomerID = C.CustomerID
INNER JOIN w3schools.shippers AS S
ON O.ShipperID = S.ShipperID
WHERE S.ShipperID IN (1, 2)
ORDER BY 1, 2, 3;
