const connection = require('../config/db');

class Livre {
    static getAllLivres(callback){
        connection.query('SELECT * FROM livres', callback);
    }

    static getLivreById(livreId, callback){
        connection.query('SELECT * FROM livres WHERE id=?', livreId, callback);
    }
    static addLivre(livreData, callback){
        connection.query('INSERT INTO `livres` SET ?', livreData, callback);
    }
    static updateLivre(livreId, livreData, callback){
        connection.query('UPDATE livres SET ? WHERE id= ?', [livreData, livreId], callback);
    }

    static deleteLivre(livreId, callback) {
        connection.query('DELETE FROM livres WHERE id= ?', livreId, callback);
    }
}

module.exports = Livre;