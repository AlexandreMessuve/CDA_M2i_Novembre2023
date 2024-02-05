# Utilisation de JSON web token (JWT) pour l'authentification

JSON Web Tokens (JWT) est un moyen populaire d'implémenter l'authentification dans les applications web. Il permet de générer des jetons qui peuvent être transmis entre le client et le serveur pour authentifier les requêtes.

Un JWT est une chaîne encodée qui contient des informations ainsi qu'une signature permettant de vérifier l'authenticité du token. Il est composé de trois parties :

- **Header**: Contient le type de token (JWT) et l'algorithme utilisé.
- **Payload**: Contient les données de l'utilisateur, telles que l'identifiant de l'utilisateur et ses autorisations.
- **Signature**: Permet de vérifier que le token n'a pas été altéré et qu'il provient bien du serveur.

## Génération et vérification des JWT dans node.JS

Lorsqu'un utilisateur se connecte avec succès, un jwt est généré et renvoyé au client pour être utilisé dans les requêtes ultérieur.

```javascript
const jwt = require('jsonwebtoken')

const generateToken = (userId) => {
  const payload = {
    userId: userId,
    // D'autres données facultatives peuvent être ajoutés.
  }

  const token = jwt.sign(payload, 'RANDOM_TOKEN_SECRET', {expiresIn: "1d"})

  return token
}
```

## Vérification du JWT lors de requête protégées

Pour protéger les routes qui nécessitent une connexion, vous pouvez utiliser un middleware pour vérifier la validité du jwt inclus dans l'en-tête Authorization de la requête.

```javascript
function isAuthenticated(req, res, next) {
  try {
    // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoxLCJpYXQiOjE3MDcxMzk2NzIsImV4cCI6MTcwNzIyNjA3Mn0.6R_w_4QVGje4emYrhZSaEEGzQJCuKFkkyn23DAO7bFU
    const token = req.headers.authorization.split(" ")[1]
    const decodedToken = jwt.verify(token, "RANDOM_TOKEN_SECRET")
    const userId = decodedToken.userId

    return next()
  } catch(error) {
    // L'utilisateur n'est pas authentifié :
    res.status(401).json({message : "Merci de vous connecter"})
  }
}
```

## Exemple d'utilisation dans un route protégée

Une fois que vous avez défini le middleware de vérification du token, vous pouvez l'utiliser dans les routes nécessitant une authentification :

```javascript
router.get('/protectedRoute', isAuthenticated, (req, res) => {
  res.send('Route protégée accessible')
})
```