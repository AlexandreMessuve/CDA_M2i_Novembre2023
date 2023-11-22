let popActual = Number(prompt('Veuillez saisir le nombre de population actuelle'));
let popInitial = popActual;
let taux = Number(prompt('Veuillez saisir le taux d\'accroissement'));
let popFinal = Number(prompt('Veuillez saisir le nombre de population visée'));
let year = 0;
while(popActual < popFinal){
    popActual = popActual*(taux/100+1);
    year++;
}
console.log(`Avec une population initial de ${popInitial}.Il vous faudra ${year} années pour atteindre ${Math.round(popActual)} habitants avec un taux d'accroissement de ${taux}%`);