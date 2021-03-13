SELECT 
C.ContactName AS Nome,
C.Country AS País,
C2.C3 AS `Número de compatriotas`
FROM w3schools.customers AS C
LEFT JOIN (SELECT C.Country AS Country, (COUNT(C.Country)-1) AS C3 FROM w3schools.customers AS C GROUP BY C.Country) AS C2
ON C.Country = C2.Country
WHERE C2.C3 > 0
ORDER BY Nome;
