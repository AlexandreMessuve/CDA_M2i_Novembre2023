const mongoose = require('mongoose');

const user = new mongoose.Schema({
    email: {type: String, required: true, unique: true},
    password:{type: String, required: true}
});

const UserSchema = mongoose.model('User', user);

module.exports = UserSchema;

