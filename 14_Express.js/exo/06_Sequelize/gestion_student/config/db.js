const Sequelize = require('sequelize');

const sequelize = new Sequelize(
    'school',
    process.env.DB_USER,
    process.env.DB_PASSWORD, {
        host: 'localhost',
        dialect: 'mysql'
    });

const User = require('../models/User')(sequelize);
const Student = require('../models/Student')(sequelize);

sequelize
    .sync({force: false})
    .then(() => console.log('La base de données à bien été synchronisée'))
    .catch((err) => console.error("Problème de synchronisation :", err.message)
    );

module.exports = {
    sequelize,
    User,
    Student
}