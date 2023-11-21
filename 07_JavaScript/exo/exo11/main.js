let epaisseur = 0.1;
let pli = 0;
let epaisseurFinal = 400000;

while(epaisseur < epaisseurFinal){
    pli++;
    epaisseur *=2;
}

console.log(`La feuille est plié ${pli} fois pour atteindre 400m`);