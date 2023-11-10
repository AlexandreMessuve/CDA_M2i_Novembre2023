# Les formulaires en HTML

Pour ouvrir et fermer un formulaire, on applique les balises `<form></form>`. Cette balise contiendra beaucoup d'attributs important pour notre JavaScript. Mais nous allons d'abord voir le placement des inputs en HTML:
## Les imputs

En html, les éléments `<input>` sont utilisés pour collecter des données entrées par les utilisateurs. Il existe plusieurs types d'input couramment utilisés pour différents types de données et d'intéraction.  
Si je veux  rendre l'un de mes input **obligatoire**, j'utilise l'attribut `required`.

1. **Texte (`text`):** Ce type d'input permet aux utilisateurs de saisir du texte livre, comme des noms, des adresses, des commentaires, ect.

```html
<input type="text" name="nom" placeholder="votre nom">
```

2. **Mot de passe (`password`):** Utilisé pour collecter des mots de passe, ce type masque les caractères saisis.

```html
<input type="password" name="password" placeholder="votre mot de passe">
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
<input type="email" name="email" placeholder="Votre email"> 
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

9. **Téléphone(`tel`):** Utilisé pour collecter des numéros de téléphone.
```html
<input type="tel" name="telephone" placeholder="0000000000"> 
```

10. **Fichier(`file`):** Les inputs de type `file` permettent aux utilisateurs de séléctionner et de téléverser des fichiers à partir de leur ordinateur.  
Grâce à l'attribut `multiple`, je peux permettre à l'utilisateur de choisir plusieur fichiers.
```html
<input type="file" name="fichier" multiple> 
```

11. **Bouton(`button`):** Cet élément créé un bouton personnalisable qui peut être utilisé pour déclencher des actions JS ou des soumission de formulaire. Il peut également vous permettre de reset le formulaire
```html
<input type="button" value="Cliquez ici" name="button"> 
<!-- Envoyer un formulaire -->
<input type="submit" value="Envoyer"> 
<!-- Reset un formulaire -->
<input type="reset" value="Reset"> 
```

## Les labels

Les balises `<label>` en HTML sont utilisées pour associer un libelé descriptif à un élément de formulaire. Les balises `<label>` sont essentielles pour améliorer l'accessibilité des formulaires web, car elles permettent aux utilisateurs de comprendre facilement ce que chaque champ de formulaire reprèsente.
```html
<label for="nom">Votre libellé</label>
<input type ="text" id="nom" name ="nom" placeholder="Votre nom" />

```

L'attribut `for` de la balise `<label>` est associé à l'attribut `id`de l'élément de formulaire que vous souhaitez étiqueter. Cela indique au navigateur que le label est lié à cet élément. Lorsque l'utilisateur clique sur le libellé, le champ de formulaire correspondant reçois le focus de l'action associée.

### Autres attributs commun

`autofocus` : Place directement l'utilisateur dans un champ au chargement de la page.
`pattern` : Permet de spécifier une expression régulière à un input (utile pour la sécurité).
`maxlenght` : Définit un nombre maximum de caractère utilisés dans l'input (utile pour la sécurité).
`minlenght` : Définit un nombre minimum de caractère utilisés dans l'input (utile pour la sécurité).
`size` : Modifie le nombre de caractères visibles dans un input.
`readonly` : Affiche une valeur qui ne peut pas être modifiée par l'utilisateur.
`value` : Pré-remplit un champ.

### La liste de sélection `select`

Pour afficher une liste déroulante en HTML, j'utiliserai la balise `<select>`. Je délimiterai chacune des options de mon sélecteur à l'aide de la balise `<option>`.
```html
<label for="pays">Pays:</label>
<select id="pays" name="pays">
    <option value="France">France</option>
    <option value="Espagne">Espagne</option>
    <option value="Pays-Bas">Pays-Bas</option>
    <option value ="Angleterre">Angleterre</option>
    <option value="Etats-Unis">Etats-Unis</option>
</select>
```

### La boîte de texte `textarea`

Un élément `textarea` est utilisé pour créer une zone de texte multiligne. Je peux définir la taille de ma boîte grâce aux attributs `rows` et `cols`.

```html
<textarea name="description" rows="5" cols="30">
    Saisir votre commentaire ici ....
</textearea>
```

### Action et méthode

Une fois que mon formulaire est complété, je demanderai à l'utilisateur de l'envoyer via un input submit ou un button. A ce moment-là, la méthode et l'action se déclancheront. Méthodes et actions se configurent à travers leurs **attributs** au sein de la balise `form`.

L'attribut `action` définit le fichier où les données du formulaire seront envoyés. On le remplit donc généralement avec un lien vers une page du serveur.

La méthode, elle, définit **le type d'envoi** de ces données. On la trouve sous deux formes: 

**La méthode GET:** On transmet les données directement via l'URL en y stockant nos paires name/valeurs. Attention, notre URL est limité à 2048 caractères, ce n'est donc pas une méthode viable pour de gros formulaires. Toutes les informations s'affichent en claire dans cet URL, on ne peut donc pas y passer de données sensibles. C'est la méthode recommandé pour des données neutres ou non personnalisées.

**La méthode POST:** Avec cette méthode on envoie les données à travers une requête HTTP. Les données sont donc masquées et il n'y a pas de limitation de taille. C'est la méthode recommandé pour tous les formulaires qui concernent directement les informations personnelles d'un utilisateur par exemple.

### Le groupement de champs

Si on veut regrouper manuellement un ensemble de champs d'un formulaire, on en a la possibilité grâce a la balise `fieldset`. par défaut, elle encadrera les différents champs regroupés. On peut nommer ces différents groupement en utilisant à l'intérieur de mon `fieldset` la commande `legend`.