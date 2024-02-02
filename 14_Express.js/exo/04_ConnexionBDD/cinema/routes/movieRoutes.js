const express = require('express');
const router = express.Router();
const movieController = require('../controllers/movieController');

router.get('/', movieController.getAllMovies);
router.get('/:title', movieController.getMovieByTitle);
router.post('/', movieController.addMovie);
router.delete('/:title', movieController.deleteMovie);

module.exports = router;