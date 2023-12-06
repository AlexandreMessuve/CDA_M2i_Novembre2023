const fs = require('fs');

fs.readdir(process.argv[2], (err, list) => {
        if(err){
            console.error(err);
            return;
        }
        list.forEach((value) => {
            const regex = new RegExp(`^[a-zA-Z.]+.+${process.argv[3]}$`);
            regex.test(value) ? console.log(value): null});

})