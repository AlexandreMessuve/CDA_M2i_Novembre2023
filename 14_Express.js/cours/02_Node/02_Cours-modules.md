# Gestion des modules en Node.js

## Compréhension du système de module intégré

Node.js, en tant qu'environnement JavaScript côté serveur, dispose d'un système de modules intégré qui permet d'organiser le code de manière modulaire. Cela favorise la réutilisation du code, la gestion des dépendances et la maintenabilité des applications.

### 1. Qu'est ce qu'un module ?

En JS, un module est essentiellement un fichier contenant du code. Ce code peut être des variables, des fonctions ou des objets, et il peut être réutilisé dans d'autres parties de l'application.

### 2. Le système de modules de Node.js

Node.js utilise un système de modules basé sur le système de fichiers local. Chaque fichier JS est considéré comme un module, et les fonctionnalitées exposées par un module peuvent être importées dans d'autres modules.

### 3. require() et module.exports

- **`require()`**: Cette fonction est utilisée pour importer des fonctionnalitées d'autres modules dans le module en cours. Elle prend en paramètre le chemin du module à importer. Par exemple:

```js
const myModule = require('./myModule');
```

- **`module.exports`**: Cette propriété est utilisée pour exporter des fonctionnalités depuis un module, les rendant ainsi accessibles pour d'autre modules. Par exemple:

```js
// Dans myModule.js
const myFunction = () => {
  // Fonctionnalités à exporter
}

module.exports = myFunction;
```

```js
//config.js
const apiKey = "your-api-key";
const apiUrl = "https://api.example.com"

module.exports = {
  apiKey,
  apiUrl
};
```