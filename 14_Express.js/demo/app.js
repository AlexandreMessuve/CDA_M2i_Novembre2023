const express = require('express');

const app = express()
const ip = '127.0.0.1';
const port = process.env.PORT || 3000;

app.get('/' ,(req, res) =>  {
   res.send('Bienvenue sur express !!!');
});

app.get('/essai', (req, res) => {
   res.send('Ceci est un essai!!');
})
app.listen(port,ip,() => {
   console.log(`Serveur en écoute sur le port ${port}`)
});