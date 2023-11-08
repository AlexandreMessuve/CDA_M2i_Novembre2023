# Les formulaires en HTML

Pour ouvrir et fermer un formulaire, on applique les balises `<form></form>`. Cette balise contiendra beaucoup d'attributs important pour notre JavaScript. Mais nous allons d'abord voir le placement des inputs en HTML:
## Les imputs

En html, les éléments `<input>` sont utilisés pour collecter des données entrées par les utilisateurs. Il existe plusieurs types d'input couramment utilisés pour différents types de données et d'intéraction.  
Si je veux  rendre l'un de mes input **obligatoire**, j'utilise l'attribut `required`.

1. **Texte (`text`):** Ce type d'input permet aux utilisateurs de saisir du texte livre, comme des noms, des adresses, des commentaires, ect.

```html
<input type="text" placeholder="votre nom">
```

2. **Mot de passe (`password`):** Utilisé pour collecter des mots de passe, ce type masque les caractères saisis.

```html
<input type="password" placeholder="votre mot de passe">
```

3. **Cases à cocher (`checkbox`):** Les cases à cocher permettent aux utilisateurs de sélectionner plusieurs options parmi un groupe d'éléments.

```html
<input type="checkbox" name="sports" value="Football"> Football
<input type="checkbox" name="sports" value="Basketball"> Basketsball
```

Le name servira à regrouper des checkbox autour d'une thématique commune. C'est l'attribut value qui nous retournera la valeur de nos checkboxes indépendantes.

4. **Boutons radio(`radio`):** Les boutons radio permettent aux utilisateurs de ne sélectionner qu'une seule option parmi un groupe d'éléments. C'est la aussi l'attribut `name` qui permet de rattacher les éléments entre eux.

```html
<input type="radio" name="sports" value="Football"> Football
<input type="radio" name="sports" value="Basketball"> Basketsball
```

5. **E-mail(`email`):** Utilisé pour collecter des adresses e-mail, il vérifie également de la syntaxe de l'adresse saisie.
```html
<input type="email" placeholder="Votre email"> 
```

6. **Date(`date`):** Utilisé pour collecter des dates, il affiche un sélecteur de date.
```html
<input type="date" name="date"> 
```

7. **Numérique(`number`):** Ce type d'input permet aux utilisateurs de saisir de valeur numérique.
```html
<input type="number" name="quantite" min="0" max="10" step="1"> 
```

8. **URL(`url`):** Utilisé pour collecter des URL (adresse de site web), il vérifie également la validité de la syntaxe de l'URL saisi.
```html
<input type="url" name="URL_web" placeholder="Votre lien"> 
```