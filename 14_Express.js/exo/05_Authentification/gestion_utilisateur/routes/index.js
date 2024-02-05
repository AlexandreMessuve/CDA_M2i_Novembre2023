const express = require('express');
const router = express.Router();

const movieRoute = require('./userRoutes');

router.use('/api', movieRoute);

module.exports = router;
