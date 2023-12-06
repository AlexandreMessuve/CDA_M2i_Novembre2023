const http = require('http');

http.get(process.argv[2], (response) => {
    response.on('data', (data) => console.log(data.toString()));
    response.on('error', console.error)
}).on('error', console.error);
