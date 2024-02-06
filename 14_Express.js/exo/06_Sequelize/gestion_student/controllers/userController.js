const { User } = require('../config/db');

const userController = {
    getAllUsers: async (req, res) =>  {
        try {
            const users = await User.findAll();
            res.status(200).json(users);
        }
        catch (e) {
            res.status(404).json({message: "Aucune donnée trouvé"})
        }
    },
    getUserById: async (req, res) =>  {
        const id = req.params.id;
        try {
            const user = await User.findByPk(id);
            res.status(200).json(user);
        }
        catch (e) {
            res.status(404).json({message: "Aucune donnée trouvé"})
        }
    },
    updateUser: async (req, res) => {
        const id = req.params.id;
        const currentUserRoles = req.auth.roles;
        const currentUserId= req.auth.userId;
        const modifiedData = req.body;
        if (currentUserRoles.find(role => role === 'admin') || id === currentUserId){
            try{
                await User.update(modifiedData, {where: {id: id}});
                res.status(204).json({message: 'Utilisateur modifié avec succès'});
            }
            catch (e) {
                res.status(404).json({message: 'Aucune donnée trouvée'})
            }
        }else {
            res.status(401).json({message: 'Vous n\'avez pas les droit pour modifier'})
        }
    },
    deleteUser: async (req, res) => {
        const id = req.params.id;
        const currentUserRoles = req.auth.roles;
        const currentUserId= req.auth.userId;
        if (currentUserRoles.find(role => role === 'admin') || id === currentUserId){
            try{
                await User.destroy({where: {id: id}});
                res.status(204).json({message: 'Utilisateur supprimé avec succès'});
            }
            catch (e) {
                res.status(404).json({message: 'Aucune donnée trouvée'})
            }
        }else {
            res.status(401).json({message: 'Vous n\'avez pas les droit pour modifier'})
        }
    }
};

module.exports = userController;