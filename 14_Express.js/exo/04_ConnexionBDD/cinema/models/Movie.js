const mongoose = require('mongoose');

const movie = new mongoose.Schema({
    title: {type: String, required: true, unique: true},
    description:{type: String, required: true},
    director: {type: String, required: true},
    releaseDate:{type: Date, required: true},
});

const MovieSchema = mongoose.model('Movie', movie);

module.exports = MovieSchema;

