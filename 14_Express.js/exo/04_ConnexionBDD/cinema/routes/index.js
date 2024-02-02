const express = require('express');
const router = express.Router();

const movieRoute = require('./movieRoutes');

router.use('/api/movies', movieRoute);

module.exports = router;
