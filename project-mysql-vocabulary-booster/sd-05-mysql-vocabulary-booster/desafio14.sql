SELECT DISTINCT
s.Country AS País
FROM w3schools.suppliers AS s
UNION
SELECT DISTINCT
c.Country AS País
FROM w3schools.customers AS c
ORDER BY País
LIMIT 5;
