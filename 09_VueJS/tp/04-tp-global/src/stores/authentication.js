// Importation des modules nécessaires
import { ref, computed } from 'vue' // Pour rendre l'état réactif et créer des valeurs calculées
import { defineStore } from 'pinia' // Pour définir un magasin d'état
import { v4 as uuid } from 'uuid' // Pour générer des identifiants uniques

// Définition du magasin d'état
export const useAuthStore = defineStore('auth', () => {
  // Initialisation de l'état avec les utilisateurs stockés dans le localStorage
  // Si aucun utilisateur n'est trouvé, une liste vide est utilisée
  const users = ref(!!JSON.parse(localStorage.getItem('users')) ? JSON.parse(localStorage.getItem('users')):[]);

  // Initialisation de l'utilisateur actuellement connecté avec les informations stockées dans le localStorage
  // Si aucun utilisateur n'est connecté, null est utilisé
  const currentUser = ref(JSON.parse(localStorage.getItem('user')) === undefined ? null : JSON.parse(localStorage.getItem('user') ));

  // Méthode pour obtenir un utilisateur en fonction de son email
  const getUserByEmail = (email) => {
    return users.value.find(u => u.email === email);
  }

  // Propriété calculée pour vérifier si un utilisateur est actuellement connecté
  const isLogging = computed(() => {
    return !!currentUser.value;
  })

  // Méthode pour enregistrer un nouvel utilisateur
  const register = (email, username, password) => {
    // Vérification si l'email est déjà utilisé
    if (!!getUserByEmail(email)) {
      // Si l'email est déjà utilisé, retourner un message d'erreur
      return {
        code: false,
        message: 'Cette email est déjà enregistré dans notre base de données'
      };
    } else {
      // Sinon, créer un nouvel utilisateur avec un identifiant unique, l'email, le nom d'utilisateur et le mot de passe donnés
      const user = {
        id: uuid(),
        email: email,
        username: username,
        password: password
      };
      users.value.push(user);
      currentUser.value = user;
      localStorage.setItem('users', JSON.stringify(users.value))
      return {
        code: true,
        message: 'Votre compte à bien été créé'
      };
    }
  }
  // Méthode pour authentifier un utilisateur
  const auth = (email, password, stayConnect) => {
    // Recherche de l'utilisateur par email
    const user = getUserByEmail(email);
    if (!!user) {
      // Si l'utilisateur est trouvé et que le mot de passe correspond, connecter l'utilisateur
      if (user.email === email && user.password === password) {
        currentUser.value = {
          email: email,
          username: user.username
        }
        // Si l'option stayConnect est activée, stocker les informations de l'utilisateur dans le localStorage
        if(stayConnect){
          localStorage.setItem('user', JSON.stringify(currentUser.value));
        }
        // Retourner un message de succès
        return {
          code: true,
          message: 'Connexion réussie'
        };
      } else {
        // Si le mot de passe ne correspond pas, retourner un message d'erreur
        return {
          code: false,
          message: 'Email ou mot de passe incorrect'
        };
      }

    } else {
      // Si l'utilisateur n'est pas trouvé, retourner un message d'erreur
      return {
        code: false,
        message: 'Vous n\'existez pas dans notre base de données'
      };
    }
  }


  const logout = () => {
    if (isLogging) {
      currentUser.value = null;
      if(localStorage.getItem('user')){
        localStorage.clear('user');
      }
    };
  }
  // Retourner l'état et les méthodes pour interagir avec lui
  return { currentUser, isLogging, register, auth, logout }
})
