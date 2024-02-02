const Movie =require('../models/Movie');

const movieController = {
    getAllMovies: async (req, res) => {
        try {
            const users = await Movie.find()  ;
            res.status(200).json(users);
        }catch (e) {
            res.status(400).json({error: e.message});
        }
    },
    getMovieByTitle: async (req, res) => {
        try {
            const title = req.params.title;
            const movie = await Movie.findOne({title: title});
            res.status(200).json(movie);
        }catch (e) {
            res.status(400).json({error: e.message});
        }
    },

    addMovie: async (req, res) => {
        try {
            const newMovie = new Movie(req.body);
            await newMovie.save();
            res.status(201).json(newMovie);
        } catch (e) {
            res.status(400).json({error: e.message});
        }
    },

    deleteMovie: async (req, res) => {
        try {
            const title = req.params.title;
            await Movie.deleteOne({title: title});
            res.status(200).json({response: 'Movie deleted successful'});
        }catch (e) {
            res.status(400).json({error: e.message});
        }
    }
}

module.exports = movieController;