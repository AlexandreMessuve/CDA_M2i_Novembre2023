USE exercice_sql_01;

-- 1
SELECT ville_nom, ville_population_2012
	FROM villes_france_free
    ORDER BY ville_population_2012 DESC 
    LIMIT 10;
    
-- 2
SELECT ville_nom, ville_surface
	FROM villes_france_free
    ORDER BY ville_surface ASC
    LIMIT 50;
    
-- 3
SELECT departement_nom, departement_code
	FROM departement
    WHERE departement_code LIKE '97%';
    
-- 4
SELECT departement_nom, ville_nom, ville_population_2012
	FROM villes_france_free
    INNER JOIN departement
    ON departement_code = ville_departement
    ORDER BY ville_population_2012 DESC
    LIMIT 10;
    
-- 5
SELECT departement_nom, departement_code, COUNT(ville_departement) AS total_villes
	FROM departement
    LEFT JOIN villes_france_free
    ON departement_code = ville_departement
    GROUP BY  departement_id
    ORDER BY total_villes DESC;
    
-- 6
SELECT departement_nom, departement_code, ROUND(SUM(ville_surface),2) AS departement_surface
	FROM departement
    LEFT JOIN villes_france_free
    ON departement_code = ville_departement
    GROUP BY  departement_id
    ORDER BY departement_surface DESC
    LIMIT 10;
    
-- 7
SELECT COUNT(*) AS total_ville
	FROM villes_france_free
    WHERE ville_nom LIKE 'Saint%';

-- 8
SELECT ville_nom, COUNT(ville_nom) AS ville_meme_nom
	FROM villes_france_free
    GROUP BY ville_nom
    HAVING ville_meme_nom > 1
    ORDER BY ville_meme_nom DESC;
    
-- 9
SELECT ville_nom, ville_surface
	FROM villes_france_free
    WHERE ville_surface > (SELECT AVG(ville_surface) FROM villes_france_free)
    ORDER BY ville_surface DESC;
    
-- 10
SELECT departement_nom, SUM(ville_population_2012) AS departement_population
	FROM villes_france_free
    INNER JOIN departement
    ON departement_code = ville_departement
    GROUP BY departement_id
    HAVING departement_population > 2000000
    ORDER BY departement_population DESC;
    
-- 11
UPDATE villes_france_free
	SET ville_nom = REPLACE(ville_nom,'-', ' ')
WHERE ville_nom LIKE 'Saint-%';

SELECT ville_nom
	FROM villes_france_free
WHERE ville_nom LIKE 'Saint %';