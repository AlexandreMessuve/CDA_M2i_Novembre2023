const fs = require('fs');
const path = require('path');
const orderPath = path.join(__dirname, 'nouveau_repertoire');
fs.mkdir(orderPath, (err) => {
    if (err) {
        console.log(err);
        return;
    }

    console.log(`dossier crée avec succes :${orderPath}`);
});
const filePath = path.join(orderPath, 'nouveau_fichier.txt');
fs.writeFile(filePath,'mon contenu', {encoding:'utf-8'}, (err) => {
    if(err) throw err;
    console.log('Saved');
});

fs.readFile(filePath, {encoding: 'utf-8'}, (err, data) => {
    if (err) throw err;
    console.log(data);
})

setTimeout(()=>{
fs.readdir(orderPath, (err, files)=> {
    if(err) throw err;
    console.log(`Les fichier dans mon répertoire : ${files}`);
});
},100)


setTimeout(() => {
fs.unlink(filePath, (err) => {
    if(err) throw err;
    console.log('Fichier supprimé');
});

fs.rmdir(orderPath, (err) => {
    if(err) throw err;
    console.log('Dossier supprimé.');
})
},200)
