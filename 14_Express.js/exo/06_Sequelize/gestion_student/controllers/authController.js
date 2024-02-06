const {User} = require('../config/db');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const authController = {
    register: async (req, res) => {
        try {
            const {username, password} = req.body;
            if (username && password) {
                const hashPassword = await bcrypt.hashSync(password, 10);
                const user = {
                    username: username,
                    password: hashPassword
                };
                await User.create(user);
                res.status(201).json({message: "Utilisateur crée avec succés"});
            } else {
                res.status(400).json({message: "Tous les champs sont requis"});
            }

        } catch (error) {
            res.status(400).json(error);
        }
    },

    authenticate: async (req, res) => {
        try {
            const {username, password} = req.body;
            if (username && password) {
                const user = await User.findOne({where: {username: username}})
                if (!user) {
                    res.status(400).json({message: "Email ou mot de passe incorrect"});
                    return;
                }
                if (bcrypt.compareSync(password, user.password)) {
                    const payload = {
                        userId: user.id,
                        userUsername: user.username,
                        userRoles: user.roles,
                    }
                    const token = jwt.sign(payload, process.env.JWT_PASSPHRASE, {expiresIn: "1d"});
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
    }
}


module.exports = authController;