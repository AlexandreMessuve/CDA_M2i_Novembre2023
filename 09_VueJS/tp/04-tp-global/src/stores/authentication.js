import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { v4 as uuid } from 'uuid'

export const useAuthStore = defineStore('auth', () => {
  const users = ref(!!JSON.parse(localStorage.getItem('users')) ? JSON.parse(localStorage.getItem('users')):[]);

  const currentUser = ref(JSON.parse(localStorage.getItem('user')) === undefined ? null : JSON.parse(localStorage.getItem('user') ));

  const getUserByEmail = (email) => {
    return users.value.find(u => u.email === email);
  }


  const isLogging = computed(() => {
    return !!currentUser.value;
  })

  const register = (email, username, password) => {
    if (!!getUserByEmail(email)) {
      console.log(false)
      return {
        code: false,
        message: 'Cette email est déjà enregistré dans notre base de données'
      };
    } else {
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
  const auth = (email, password, stayConnect) => {
    const user = getUserByEmail(email);
    if (!!user) {
      if (user.email === email && user.password === password) {
        currentUser.value = {
          email: email,
          username: user.username
        }
        if(stayConnect){
          localStorage.setItem('user', JSON.stringify(currentUser.value));
        }
        return {
          code: true,
          message: 'Connexion réussie'
        };
      } else {
        return {
          code: false,
          message: 'Email ou mot de passe incorrect'
        };
      }

    } else {
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
  return { currentUser, isLogging, register, auth, logout }
})
