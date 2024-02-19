const Sequelize = require('sequelize');

const sequelize = new Sequelize(
    'bibliotheque',
    'root',
    'root', {
    host: 'localhost',
    dialect: 'mysql'
});

(async () => {
    try {
        await sequelize.authenticate();
        console.log('Connected successful')
    } catch (e) {
        console.log(e)
    }
})()
