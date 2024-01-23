const http = require('http');
http.get(process.argv[2], (response) => {
    let collect = '';
    response.setEncoding('utf-8');
    response.on('error', (err) => {
        if (err) throw err;
    });
    response.on('data',(data) => {
        collect += data.toString();
    });
    response.on('end',() => {
        console.log(collect.length);
        console.log(collect);
    })
}).on('error', console.error);
