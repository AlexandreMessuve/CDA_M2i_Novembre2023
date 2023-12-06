const myModule = require('./mymodule.js');

myModule(process.argv[2], process.argv[3], (err, data)=>{ 
    if(err){return console.error(err)} 
    data.forEach(value => console.log(value));
});


