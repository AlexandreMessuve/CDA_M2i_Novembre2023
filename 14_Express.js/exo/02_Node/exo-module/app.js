// Version module export

//const bookInfo = require('./bookInfo');

//console.log(`Info du bouquin : \n Nom: ${bookInfo.nom} \n Parution: ${bookInfo.parution.toLocaleDateString()} \n Auteur: ${bookInfo.auteur}`);

// Version Module ES6

import {myConst, myFunction} from "./bookInfo.js";

console.log(myConst);
myFunction();

