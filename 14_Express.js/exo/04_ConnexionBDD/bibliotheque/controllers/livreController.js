const Livre =require('../models/Livre');

const livreController = {
    getAllLivres: (req, res) =>{
        Livre.getAllLivres((err, livres) => {
            if(err) throw err;
            if(livres.length > 0){
            res.json(livres);
            } else{
                res.status(404).send('aucun livre trouvé');
            }
        })
    },

    getLivreById: (req, res) => {
        const  id = req.params.id;
      Livre.getLivreById(id, (err, livre) => {
          if(err) throw err;
          if(livre.length > 0){
              res.json(livre);
          } else{
              res.status(404).send('aucun livre trouvé avec cet id');
          }
      })
    },

    addLivre: (req, res) => {
        const livreData = req.body;
        Livre.addLivre(livreData, (err, result) => {
            if(err) {
                console.log(err);
                res.status(500).send('Impossible d\'ajouter le livre.');
                return;
            }
            res.send('Livre ajouté avec succès');
        })
    },

    updateLivre: (req, res) => {
        const livreId = req.params.id;
        const livreData = req.body;
        Livre.updateLivre(livreId, livreData, (err, result) => {
            if(err) throw err;
            res.send('Livre modifié avec succès');
        });
    },

    deleteLivre: (req, res) => {
        const livreId = req.params.id;
        Livre.deleteLivre(livreId, (err, result) => {
            if(err) {
                console.log(err);
                res.status(500).send('Impossible de supprimer le livre.');
                return;
            }
            res.send('Livre supprimé avec succès');
        })
    }
}

module.exports = livreController;