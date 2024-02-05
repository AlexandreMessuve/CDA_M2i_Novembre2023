const express = require('express');
const router = express.Router();
const userController = require('../controllers/userController');
const isAuth = require('../service/authentication');

router.post('/register', userController.registerUser);
router.post('/auth', userController.authenticateUser);
router.get('/profile', isAuth, userController.profile);

module.exports = router;