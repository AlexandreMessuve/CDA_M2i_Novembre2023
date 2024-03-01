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
    getMovieById: async (req, res) => {
        try {
            const id = req.params.id;
            const movie = await Movie.findOne({_id: id});
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

    updateMovie: async (req, res) => {
      try {
          const id = req.params.id;
          const updateMovie = req.body;
          await Movie.updateOne({_id: id}, {$set: {updateMovie}})
          res.status(202).json({response: 'Success'});
      }catch (e) {
          res.status(400).json({error:e.message});
      }
    },
    deleteMovie: async (req, res) => {
        try {
            const id = req.params.id;
            await Movie.deleteOne({_id: id});
            res.status(200).json({response: 'Movie deleted successful'});
        }catch (e) {
            res.status(400).json({error: e.message});
        }
    }
}

module.exports = movieController;