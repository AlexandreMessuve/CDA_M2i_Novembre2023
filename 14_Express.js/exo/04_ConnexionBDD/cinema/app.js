require('./config/db');
const express = require('express');
const cors = require('cors');
const app = express();
const bodyParser = require('body-parser');
const allRouter = require('./routes');
const ip = '127.0.0.1';
const port = process.env.PORT || 3000;
app.use(cors());
app.use(bodyParser.json());
app.use('/', allRouter);

app.listen(port, ip, ()=> {
    console.log(`Serveur en écoute sur le port ${port}`);
});