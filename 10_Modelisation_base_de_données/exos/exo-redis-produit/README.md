### Exercice : Système de Gestion de Stock Simple avec Redis et Node.js

**Objectif :** Créer un système en mode console pour gérer un inventaire de produits, utilisant Redis pour stocker et récupérer des données.

**Fonctionnalités clés :**

1. **Ajout de Produits :**
   - Permettre à l'utilisateur d'ajouter des produits avec des attributs tels que le nom, la quantité, et le prix.

2. **Mise à Jour des Stocks :**
   - Fournir une fonctionnalité pour mettre à jour la quantité en stock d'un produit.

3. **Affichage des Stocks :**
   - Permettre à l'utilisateur de voir tous les produits disponibles et leurs quantités.

4. **Suppression de Produits :**
   - Permettre la suppression de produits de l'inventaire.

**Exemple d'Interaction en Console :**

```plaintext
> node app.js
Bienvenue dans le système de gestion de stock.
Choisissez une option :
1. Ajouter un produit
2. Mettre à jour un produit
3. Afficher les stocks
4. Supprimer un produit
5. Quitter

Votre choix : 1
Nom du produit : Chaise de bureau
Quantité : 10
Prix : 59.99

Produit ajouté avec succès !

Votre choix : ...
```
