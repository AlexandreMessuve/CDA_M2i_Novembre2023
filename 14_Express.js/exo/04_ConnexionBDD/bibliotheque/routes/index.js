const express = require('express');
const router = express.Router();

const livreRoute = require('./livreRoutes');

router.use('/api/livres', livreRoute);

module.exports = router;
