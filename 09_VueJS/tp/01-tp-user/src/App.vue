<script setup>
import { ref } from 'vue';
import { v4 as uuidv4 } from 'uuid';
import AddUser from './components/AddUser.vue';
import UserItem from './components/UserItem.vue';

const users = ref([]);

const addUser = (name, email) => {
  users.value.push({
    id: uuidv4(),
    name: name,
    email: email
  });
}

const updateUser = (name, email, id) => {
  users.value.forEach((user) => {
    if (user.id === id) {
      user.name = name;
      user.email = email;
    }
  });
}

const removeUser = (index) => {
  users.value.splice(index,1);
}
</script>

<template>
  <div class="container mt-5">
    <h1 class="text-center">Users</h1>
    <AddUser class="m-5" @add-user="addUser" />
    <table class="table table-bordered mt-5">
      <thead align="center">
        <th>Name</th>
        <th>Email</th>
        <th></th>
      </thead>
      <tbody align="center">
        <UserItem v-if="users.length > 0" v-for="(user, index) in users" :key="user.id" :name="user.name"
          :email="user.email" :id="user.id" :index="index" @update-user="updateUser" @remove-user="removeUser"/>
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
