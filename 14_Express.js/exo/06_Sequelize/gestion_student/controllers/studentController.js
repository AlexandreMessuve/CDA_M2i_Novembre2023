const { Student } = require('../config/db');

const studentController = {
    getAllStudents: async (req, res) =>  {
        try {
            const students = await Student.findAll();
            if(students.length > 0){
            res.status(200).json(students);
            }else{
                res.status(404).json({message: 'Aucun étudiant trouvé'});
            }
        }
        catch (e) {
            res.status(500).json(e);
        }
    },
    getStudentById: async (req, res) =>  {
        const id = req.params.id;
        try {
            const student = await Student.findByPk(id);
            if (student.length > 0){
            res.status(200).json(student);

            }else {
                res.status(404).json({message: 'Aucun étudiant trouvé'});
            }
        }
        catch (e) {
            res.status(500).json(e);
        }
    },
    createStudent: async (req, res) => {
        const currentUserRoles = req.auth.roles;
        if (currentUserRoles.find(role => role === 'admin')){
            try{
                const {firstname, lastname} = req.body;
                await Student.create({firstname: firstname, lastname: lastname});
                res.status(201).json({message: 'Etudiant crée avec succès'});
            }
            catch (e) {
                res.status(404).json({message: 'Erreur lors de l\'ajout'});
            }
        }else {
            res.status(401).json({message: 'Vous n\'avez pas les droit pour ajouter un etudiant'});
        }
    },
    updateStudent: async (req, res) => {
        const id = req.params.id;
        const currentUserRoles = req.auth.roles;
        const modifiedData = req.body;
        if (currentUserRoles.find(role => role === 'admin')){
            try{
                await Student.update(modifiedData, {where: {id: id}});
                res.status(204).json({message: 'Etudiant modifié avec succès'});
            }
            catch (e) {
                res.status(404).json({message: 'Erreur lors de la modification'});
            }
        }else {
            res.status(401).json({message: 'Vous n\'avez pas les droit pour modifier'});
        }
    },
    deleteStudent: async (req, res) => {
        const id = req.params.id;
        const currentUserRoles = req.auth.roles;
        if (currentUserRoles.find(role => role === 'admin')){
            try{
                await Student.destroy({where: {id: id}});
                res.status(204).json({message: 'Etudiant supprimé avec succès'});
            }
            catch (e) {
                res.status(404).json({message: 'Erreur lors de la suppression'});
            }
        }else {
            res.status(401).json({message: 'Vous n\'avez pas les droit pour supprimer'});
        }
    }
};

module.exports = studentController;