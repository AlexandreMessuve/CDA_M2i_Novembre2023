const User = require('../models/User');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const userController = {
    registerUser: async (req, res) => {
        try {
            const {email, password} = req.body;
            if (email && password) {
                const hashPassword = await bcrypt.hashSync(password, 10);
                const user = {
                    email: email,
                    password: hashPassword
                };
                const newUser = new User(user);
                await newUser.save();
                res.status(201).json({message: "Utilisateur crée avec succés"});
            } else {
                res.status(400).json({message: "Tous les champs sont requis"});
            }

        } catch (error) {
            res.status(400).json(error);
        }
    },

    authenticateUser: async (req, res) => {
        try {
            const {email, password} = req.body;
            if (email && password) {
                const user = await User.findOne({email: email});
                if (!user) {
                    res.status(400).json({message: "Email ou mot de passe incorrect"});
                    return;
                }
                if (bcrypt.compareSync(password, user.password)) {
                    const payload = {
                        userId: user.id,
                        userEmail: user.email
                    }
                    const token = jwt.sign(payload, 'RANDOM_TOKEN_SECRET', {expiresIn: "1d"});
                    res.status(200).json({token: token});
                } else {
                    res.status(400).json({message: "Email ou mot de passe incorrect"});
                }
            } else {
                res.status(400).json({message: "Tous les champs sont requis"});
            }
        } catch (e) {
            res.status(400).json(e)
        }
    },

    profile: async (req, res) => {
        try {
            const userId = req.auth.userId;
            const user = await User.findById(userId);

            res.status(200).json({user});// nom prenom ect .....

        } catch (e) {
            res.status(400).json({error: e});
        }
    }
}


module.exports = userController;