let epaisseur = 0.1;
let pli = 0;
let epaisseurFinal = 400000;

while(epaisseur < epaisseurFinal){
    pli++;
    epaisseur *=2;
}

console.log(`La feuille est plié ${pli} fois pour atteindre 400m`);

let depli = 0;
while(epaisseurFinal >= 0.1 ){
    depli++;
    epaisseurFinal /=2;
}

console.log(`La feuille est déplié ${depli} fois pour atteindre 0.1mm`);