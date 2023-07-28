SELECT p.name person_name, c.name company_name
FROM person p LEFT JOIN company c ON p.company_id = c.id
WHERE company_id !=5;

SELECT c.name company, COUNT(company_id) max_persons
FROM person p LEFT JOIN company c ON p.company_id = c.id
GROUP BY company
HAVING COUNT(company_id) = (
SELECT MAX(mycount)
FROM (
SELECT company_id, COUNT(company_id) mycount
FROM person
GROUP BY company_id) sub);
