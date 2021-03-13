SELECT 
P.ProductName AS Produto,
MIN(OD.Quantity) AS Mínima,
MAX(OD.Quantity) AS Máxima,
ROUND(AVG(OD.Quantity),2) AS Média
FROM w3schools.order_details AS OD
INNER JOIN w3schools.products AS P
ON OD.ProductID = P.ProductID
GROUP BY OD.ProductID
HAVING ROUND(AVG(OD.Quantity),2) > 20
ORDER BY 4, 1;
