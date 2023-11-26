function random() {
    let rand = Math.random() * 50;

    while (rand === 0) {
        rand = Math.random() * 50;
    }

    return Math.round(rand);
}
function pair(item) {
    return item % 2 === 0 ? 'pair'.padStart(8) : 'impair';
}

function showPair() {
    let tab = [];
    let response = "";
    let maxTab = Number(prompt('Veuillez saisir la longueur du tableau : '));

    while (isNaN(maxTab)) {
        maxTab = Number(prompt('Saisie invalide !\n Veuillez saisir la longueur du tableau :'));
    }

    for (let i = 0; i < maxTab; i++) {
        tab.push(random());
    }
    tab.forEach((item, index) => {
        response += `Le nombre ${item.toString().length === 1 ? item.toString().padStart(3) : item} est ${pair(item)}.\n`
    })

    alert(response);
}

showPair();