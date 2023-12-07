<script setup>
</script>

<template>
    <header>
        <h1>
            Bienvenue sur mes exos en VueJS
        </h1>
        <nav class="navbar">
            <ul>
                <router-link to='/'>
                    <li><a href="#">Accueil</a></li>
                </router-link>
                <router-link to="/exercices">
                    <li><a href="#">Exercices</a></li>
                </router-link>
            </ul>
        </nav>
    </header>
</template>

<style scoped>
header {
    background-color: rgb(249, 156, 156);
}

header h1 {
    font-weight: 700;
}

nav.navbar ul {
    font-size: 1.5em;
    padding: 0;
    display: flex;
    justify-content: center;

}

li {
    list-style-type: none;
    margin-left: 15px;
}

li a {
    text-decoration: none;
    color: rgb(20, 101, 195);
}

li a:hover {
    color: rgb(74, 152, 241);
}</style>