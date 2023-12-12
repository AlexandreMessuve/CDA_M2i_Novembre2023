<script setup>
import { ref, provide } from 'vue';
import { v4 as uuidv4 } from 'uuid';
import AddUser from './components/AddUser.vue';
import UserItem from './components/UserItem.vue';

// Déclaration des variables réactives
const resultMessage = ref('');
const resultClass = ref('');
const result = ref(false);
const users = ref([]);
const resultSuccess = ref(false);

provide ('success', {
  resultSuccess
})
// Fonction pour afficher le résultat
const showResult = (success, message) => {
  if (success) {
    resultMessage.value = message;
    resultClass.value = 'alert-success';
  } else {
    resultMessage.value = message;
    resultClass.value = 'alert-danger';
  }
  result.value = true;
}

// Fonction pour vérifier si l'utilisateur existe déjà
const userExist = (email, id = null) => {
  let flag = false;
  users.value.forEach((user) => {
    if (user.email === email && id !== user.id) {
      flag = true;
    }
  })
  return flag;
}

// Fonction pour ajouter un utilisateur
const addUser = (name, email, success, message) => {
  if (users.value.length > 0) {
    if (userExist(email)) {
      success = false;
      message = 'L\'utilisateur existe déjà';
      resultSuccess.value = false;
    }
  }
  if (success) {
    resultSuccess.value = true;
    users.value.push({
      id: uuidv4(),
      name: name,
      email: email
    });
  }
  showResult(success, message);
}

// Fonction pour mettre à jour un utilisateur
const updateUser = (name, email, id, success, message) => {
  if (userExist(email, id)) {
    success = false;
    message = 'L\'utilisateur existe déjà';
  }
  if (success) {
    users.value.forEach((user) => {
      if (user.id === id) {
        user.name = name;
        user.email = email;
      }
    });
  }
  showResult(success, message);
}

// Fonction pour supprimer un utilisateur
const removeUser = (index) => {
  users.value.splice(index, 1);
}
</script>

<template>
  <div class="container mt-5">
    <h1 class="text-center">Users</h1>
    <AddUser class="m-5" 
    @add-user="addUser" 
    @show-result="showResult"
    />
    <div v-if="result" class="rounded-2 alert alert-dismissible fade show" role="alert" :class="resultClass">
      {{ resultMessage }}
      <button type="button" class="btn-close" @click="result = !result" aria-label="Close">
      </button>
    </div>
    <table class="table table-bordered mt-5">
      <thead align="center">
        <th>Name</th>
        <th>Email</th>
        <th></th>
      </thead>
      <tbody align="center">
        <UserItem v-if="users.length > 0" v-for="(user, index) in users" :key="user.id" :name="user.name"
          :email="user.email" :id="user.id" :index="index" @update-user="updateUser" @remove-user="removeUser" @show-result="showResult"/>
        <tr v-else>
          <td>Rien</td>
          <td>Rien</td>
          <td>Rien</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
