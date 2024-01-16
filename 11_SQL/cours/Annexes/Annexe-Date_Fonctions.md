1. **YEAR(date)** : Renvoie l'année de la date spécifiée sous forme d'un entier.

   ```sql
   SELECT YEAR('2022-01-09') AS Mois;
  

2. **MONTH(date)** : Renvoie le mois de la date spécifiée sous forme d'un entier compris entre 1 et 12.

   ```sql
   SELECT MONTH('2022-01-09') AS Mois;
   ```

3. **DAY(date)** : Renvoie le jour du mois de la date spécifiée sous forme d'un entier compris entre 1 et 31.

   ```sql
   SELECT DAY('2022-01-09') AS Jour;
   ```

4. **DATE_FORMAT(date, format)** : Formate la date selon le format spécifié. Les formats peuvent inclure des éléments tels que %Y pour l'année à quatre chiffres, %m pour le mois, %d pour le jour, etc.

   ```sql
   SELECT DATE_FORMAT('2022-01-09', '%Y-%m-%d') AS Date_Formatee;
   ```

5. **NOW()** : Renvoie la date et l'heure actuelles.

   ```sql
   SELECT NOW() AS Date_Actuelle;
   ```

6. **CURDATE()** : Renvoie la date actuelle.

   ```sql
   SELECT CURDATE() AS Date_Actuelle;
   ```

7. **CURTIME()** : Renvoie l'heure actuelle.

   ```sql
   SELECT CURTIME() AS Heure_Actuelle;
   ```

8. **DATEDIFF(date1, date2)** : Renvoie la différence en jours entre deux dates.

   ```sql
   SELECT DATEDIFF('2022-01-09', '2022-01-01') AS Difference_Jours;
   ```

9. **DATE_ADD(date, INTERVAL value unit)** : Ajoute une certaine valeur (exprimée en unités comme DAY, MONTH, YEAR, etc.) à une date.

   ```sql
   SELECT DATE_ADD('2022-01-09', INTERVAL 1 MONTH) AS Date_Ajoutee;
   ```