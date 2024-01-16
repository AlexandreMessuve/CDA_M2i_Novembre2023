# Sujet 1: Gestion d’une PME

Soit une PME spécialisée dans la mise à disposition des employés pour le compte de ses clients. Chaque intervention donne lieu à un contrat avec le client. Les principales informations du contrat sont :

- La description de l’intervention.
- La date du début de l’intervention.
- La qualification précise de chaque intervenant (il existe une vingtaine de qualifications possibles).
- Le nombre d’employé prévu pour x jours.

À chaque qualification correspond un tarif journalier. La PME s’accorde en interne une certaine souplesse sur la détermination précise de la qualification de son personnel en procédant de la manière suivante :

- Chaque personne possède a priori une qualification de base.
- À chaque intervention, il est possible de réajuster la qualification. La qualification d’intervention est déterminée pour un contrat donné.


# SUJET 2 : Examens

- Les Examens nationaux sont gérés par l'Inspection Académique et concernent les élèves de cette académie. Les élèves doivent obligatoirement remplir un dossier d'inscription numéroté avant le 31 décembre de l'année scolaire en cours. Ce dossier comprend :
    - Le nom de l’élève.
    - La date de naissance.
    - L’établissement de l’élève.
    - Le nom de l'examen.
    
    Un établissement est défini par :
    - Son code.
    - Son nom.
    - Son adresse.
    - La ville.

- Chaque examen comprend une série d'épreuves qui lui est propre, chacune dotée d'un coefficient. Chaque épreuve d'examen se déroule donc à la même date dans toute l’académie.

- La gestion de ces examens comprend aussi :
    - La convocation d'une dizaine d'enseignants de l'académie à la commission de rédaction du sujet de chaque épreuve. Cette commission se réunit à l'inspection académique au plus tard 2 mois avant la date de l'épreuve.
    - Les corrections ont lieu le lendemain de l'épreuve. 
    
    Un enseignant est connu par :
    - Son matricule.
    - Son nom.
    - Son téléphone.
    - Adresse.
    - Ville.
    - Son établissement.

- La centralisation des notes de l'élève est faite sur un bordereau transmis au jury chargé d'examiner l'admission définitive du candidat.


# SUJET 3 : Appel d’offre

- **Processus d'Appel d'Offre pour un Nouveau Produit** :
  - Lorsque le service production souhaite un fournisseur pour un nouveau produit, il en fait la demande au service achats.
  - Le service achats crée le produit et saisit :
    - Les caractéristiques du produit.
    - Les caractéristiques de l’appel d’offres : N° offre, Date offre, Date clôture offre, Quantité du produit dans l’offre, N° Produit et nom du produit.
  - L'appel d’offres est lancé généralement par voie de presse spécialisée.

- **Réception et Traitement des Offres** :
  - Le service achats reçoit des offres fermes de fournisseurs.
  - À réception de ces offres, les caractéristiques du fournisseur sont saisies dans une table fournisseur (N°, nom, Adresse, CP, Ville).

- **Examen des Offres** :
  - À la date de dépouillement de l’appel d’offre, si des offres fermes ont été reçues, le service achats les examine.

- **Sélection du Fournisseur** :
  - Le service achats choisit la meilleure proposition, en tenant compte de la réputation du fournisseur.
  - Informe le directeur d’usine du fournisseur choisi.
  - Après accord du directeur d’usine, le service achats informe les candidats par une lettre de refus ou d’acceptation, accompagnée d’un contrat pour le fournisseur choisi.
  - Les caractéristiques du contrat sont saisies dans une table contrat (Numéro du contrat, date du contrat, quantité négociée, signature d’acceptation ou de refus).

- **Communication avec le Service Production** :
  - Le service achats informe le service production du choix du fournisseur.
  - Le produit devient disponible à la commande, ce qui se traduit par la saisie du prix unitaire du produit dans la table produit.
