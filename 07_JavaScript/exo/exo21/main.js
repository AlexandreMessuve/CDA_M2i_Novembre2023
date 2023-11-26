function tabulationIncrement(tabulation) {
    return tabulation += '\t';
}
function show() {
    let tab = [];
    let tabulation = "\t";
    let response = "";
    for (let i = 0; i < 10; i++) {
        tab[i] = Number(prompt(`Saisir la valeur n°${i + 1}`));
    }

    tab.forEach((item, index) => {
        response += `${index === 0 ? "" : tabulation}${item}\n`;
        index !== 0 ? tabulation = tabulationIncrement(tabulation) : null;
    })

    alert('Affichage des valeurs saisies :\n'+response);
}

show();