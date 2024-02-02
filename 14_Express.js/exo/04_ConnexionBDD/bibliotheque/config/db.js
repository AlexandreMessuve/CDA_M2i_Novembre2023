const mysql = require('mysql2');

const connection = mysql.createConnection(
    {
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        database: 'bibliotheque'
    }
);

connection.connect(err => {
    if(err) {
        console.log(`Erreur lors de la connexion à la bdd:`, err)
    }else {
        console.log('Connexion à MySQL réussie')
    }
});

module.exports = connection;