const fs = require('fs');

let myFile = fs.readFileSync(process.argv[2], {encoding: 'utf-8'})
console.log(myFile.split('\n').length - 1);