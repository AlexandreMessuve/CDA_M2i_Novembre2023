const fs = require('fs');

const file = (path, extension, callback) => {
    fs.readdir(path, (err, list) => {
        if (err) {
            return callback(err);
        }
        const data = []
        list.forEach((value) => {
            const regex = new RegExp(`^[a-zA-Z.]+.+${extension}$`);
            if (regex.test(value)) {
                data.push(value)
            }
        });

        callback(null, data);
    })
}

module.exports = file
