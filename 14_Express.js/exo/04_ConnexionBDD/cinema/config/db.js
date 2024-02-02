const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/cinema', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});
const connection = mongoose.connection;

connection.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
connection.once('open',() => {
    console.log('Connected to MongoDB')
})

module.exports = connection;