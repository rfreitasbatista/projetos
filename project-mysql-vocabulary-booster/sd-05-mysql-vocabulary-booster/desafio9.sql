SELECT
CONCAT(E.firstName, ' ', E.lastName) `Nome completo`,
COUNT(O.EmployeeID) `Total de pedidos`
FROM w3schools.orders AS O
INNER JOIN w3schools.employees AS E
ON E.EmployeeID = O.EmployeeID
GROUP BY O.EmployeeID
ORDER BY `Total de pedidos`;
