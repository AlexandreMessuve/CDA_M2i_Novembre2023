# Inscription et connexion d'utilisateur avec bcrypt dans node.js et express.

Dans le développement d'application web, l'inscription et la connexion d'un utilisateur sont des fonctionnalités essentielles. Pour garantir la sécurité des données de l'utilisateur, il  est crucial de stocker les mots de passe de manière sécurisée. Bcrypt est une bibliotheque utilisée en Node.js pour le hachage sécurisé des mots de passe.

## L'inscription d'un utilisateur

L'inscription d'un utilisateur implique la création d'un compte utilisateur avec un nom d'utilisateur ou email et un mot de passe.

- Recevoir les données du formulaire : Dans votre application express, utilisez une route POST pour recevoir les données d'inscription.

- Hachage du mot de passe : Utilisez Bcrypt pour hacher le mot de passe avant de le stocker dans la base de données.

```javascript
const bcrypt = require('bcrypt')

const saltRounds = 10 // Nombre de "tour" pour le hachage (idéalement entre 10 et 15)

bcrypt.hash(password, saltRounds, (err, hash) => {
  // Stocker le hash du mot de passe dans la base de données
})
```

- Stockage des données de l'utilisateur : Stockez le nom d'utilisateur et le hash du mot de passe dans votre base de données.

## Connexion d'un utilisateur

La connexion d'un utilisateur implique la vérification de l'identité de l'utilisateur en comparant le mot de passe fourni avec le hash stocké dans la base de données :

- Recevoir les données du formulaire: Dans express utilisez une route POST pour recevoir les données du formulaire de connexion.

- Récupération du hash du mot de passe : Récupérez le hash du mot de passe stocké dans la base de données pour l'utilisateur correspondant à l'email fourni.

- Vérification du mot de passe : Utilisez la méthode compare de Bcrypt pour comparer le mot de passe fourni avec le hash stocké dans la base de données.

```javascript
bcrypt.compare(password, hashFromDataBase, (err, result) => {
  if(result) {
    // Mot de passe correct, authentification est réussie
  } else {
    // Mot de passe incorrect, authentification échouée
  }
})

```