const http = require('http');
const bl = require('bl');
http.get(process.argv[2], (response) => {
    response.pipe(bl((err, data) => {
        if(err){
         return console.error(err);
        }
        console.log(data.toString().length)
        console.log(data.toString())

    }))
}).on('error', console.error);
