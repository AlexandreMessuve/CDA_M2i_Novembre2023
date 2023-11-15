<!-- Faire un titre en Markdown -->
# Cours sur le markdown

<!-- Faire un sous-titre en Markdown -->
## Qu'est ce que le markdown ?

Le Mardown est un langage de bnalisage léger. C'est un systeme de formatage de texte qui permet aux utilisateurs d'écrire du contenu en utilisant une syntaxe simple et lisible, puis de le convertir en HTML ou d'autres formats de documentation. Le Markdown a été créé par John Gruber en 2004 avec l'objectif de faciliter l'écriture pour le web, en offrant une alternative plus simple et plus intuitive à la rédaction directe en HTML.

La syntaxe du Mardown est conçue pour être facile à écrire et à lire même sous forme brute, tout en permettant de définir la structure du contenu, telle que les titres, les listes, les liens, les images , les citations, ect...

Le Markdown est souvent utilisé dans des contextes ou une mise en forme siple et rapide est nécessaire, comme la rédation de documents, de courriels, de pages de documentation, de messages sur les plateformes de collaboration, et même pour la rédaction de contenu de blog et d'articles en ligne. De nombreux sites et plateformes, y compris Github, Gitlab, Reddit, Discord, prennent en charge la syntaxe Markdown pour la création de contenu.

## Mise en forme du texte

Si je souhaite passe à la ligne, j'utilise un double espace suivi d'un retour à la ligne.  

Si je souhaite passe à un autre paragraphe, je saute juste une ligne.

Je peux créer des séparateurs en enchainant trois tirets après avoir sauté une ligne.

---

## Balises importantes

Le Markdown est un langage de balisage, cela signifie que si je veux l'utiliser , je dois entourer mon texte de balises spécifique au langage:

Si je souhaite mettre mon texte en **gras**, j'utilise la double étoile (elles doivent être collées au mot).  
Si je souhaite mettre mon texte en *italic*, j'utilise des étoiles simple.  
Le texte barré se fait avec deux tildes, ~~comme ceci~~.  
Le texte souligné n'est pas possible en Markdown, <u>contrairement au HTML.</u>

> Si je souhaite faire une citation, je commence ma ligne par un chevon fermant (>) suivi d'un espace.  
Ma citation peut faire plusieurs lignes.

## Les listes

Je peux faire une liste en utilisant simple les tirets, les sous-listes sont possibles également grâce à l'indantation: 

- Objet 1 
- Objet 2
    - Sous-objet 1
    - sous-objet 2

Je peux également faire des listes numériques, en précisant le chiffre avec un point: 

1. Objet 1
2. Objet 2
3. Objet 3

## Caractères d'échappement 
Parfois, j'ai besoin d'utiliser les caractères spéciaux en dehors de mon interprétation par le Markdown, je peux les faire échapper du code grâce au **backslash** (\\), je peux ainsi afficher ceci par exemple \*\* mot non gras **.

## Insérer du code en Markdown 

Le Markdown nous permet d'ajouter du code, en le balisant entre des backticks(`): 

`Exemple de code`

On peut également préciser le langage en entourant notre texte de trois backticks et en précisant le langage sur la première ligne

```javascript
let x, y;
function function1() {
    wile(x<y){
        cpnsole.log("error");
    }
}
```

## Ajout de liens et d'images

Si je souhaite ajouter un lien a mon fichier Markdown, il me faut utiliser la syntaxe suivante:

[Google](https://google.com/)

Pour une image; c'est la meme chose, je rajoute juste un point d'exclamation au début de ma syntaxe

![logo google](C:\Users\mkone\Desktop\2023-06-22_12-21.png)

C'est également possible de le faire depuis une image de contenu dans mon ordinateur.

## Les Tableaux

Il es également possible de faire des tableaux, je séparerai mes colonnes par des pipes (|), et mes lignes par des tirets (-): 

Colonne 1 | Colonne 2 | Colonne 3 |
|:--------|:---------:|----------:|
|gauche   |centre     |droite     |

Avec le double-point, je peux modifier l'alignement de mes colonnes.