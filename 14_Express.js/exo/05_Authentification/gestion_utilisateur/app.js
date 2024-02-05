require('./config/db');
const express = require('express');
const app = express();
const allRouter = require('./routes');
const bodyParser = require('body-parser');
const ip = '127.0.0.1';
const port = process.env.PORT || 3000;
app.use(bodyParser.json());
app.use('/', allRouter);

app.listen(port, ip, ()=> {
    console.log(`Serveur en écoute sur le port ${port}`);
});