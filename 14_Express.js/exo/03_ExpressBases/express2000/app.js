const express = require('express');
const path = require("path");

const app = express();
const bookRouter = require('./routes/bookRoutes');
const ip = '127.0.0.1';
const port = process.env.PORT || 3000;

app.use(express.static('public'));
app.use(express.json());
app.use(express.urlencoded());
app.get('/bienvenue' ,(req, res) =>  {
    res.send('<h1 style="text-align: center">Bienvenue sur express2000</h1>');
});

app.get('/info', (req, res) => {
    const json = {
        firstname: 'Alexandre',
        lastname: "Messuve",
        age: 26
    }
    res.json(json);
});

app.get('/acces-interdit', (req, res) => {
   res.status(403).send(
       '<h1 style="text-align: center; color: red">Acces a cette page est interdit</h1>'+
            '<div style="text-align: center"><img style="margin: auto" src="https://media1.tenor.com/m/x8v1oNUOmg4AAAAd/rickroll-roll.gif" alt="gif rick roll"></div>'

   )
});

app.get('/redirection-accueil', (req, res) => {
    res.redirect('/bienvenue');
});

app.get('/admin', (req, res) => {
    res.redirect('/acces-interdit');
});

const html404 = path.resolve('public', '404.html');
app.get('/404', (req, res) => {
   res.status(404).sendFile(html404);
});

app.use('/books', bookRouter);
app.get('*', (req, res) => {
    res.redirect('/404');
});

app.listen(port,ip,() => {
    console.log(`Serveur en écoute sur le port ${port}`)
});