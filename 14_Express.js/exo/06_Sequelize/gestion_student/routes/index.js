const express = require('express');
const router = express.Router();

const authRoute = require('./authRoutes');
const userRoutes = require('./userRoutes');
const studentRoutes = require('./studentRoutes');
const isAuth = require('../service/isAuthentificated');

router.use('/', authRoute);
router.use('/api/users', isAuth, userRoutes);
router.use('/api/students', isAuth, studentRoutes);

module.exports = router;
