function controlNumber(number, msg){
    //on contrôle la saisie du nombre tant qu'il est NaN on continue de lui demandé un nombre
    while (isNaN(number)) {
        number = Number(prompt('Erreur !\n'+msg))
    }
    return number;
}

function controlNote(note){
    //On controle les note saisie tant qu'ils sont inférieur à 0 et supérieur à 20
    //On lui demande de resaisir une note entre 0 et 20
    while (note < 0 || note > 20) {
        note = Number(prompt('ERREUR, veuillez réessayer :'));
        note = controlNumber(note, 'veuillez réessayer :');
    }
    return note;
}

function noteMax(tab){
    //Affiche la note max du tableau
    let max = Math.max(...tab);
    return `La note maximale est de ${max.toFixed(2)} / 20`;
}

function noteMin(tab){
    //Affiche la note min du tableau
    let min = Math.min(...tab);
    return `La note minimale est de ${min.toFixed(2)} / 20`;
}

function noteMoy(tab){
    //Calcul et affiche la moyenne des notes
    let sum =  tab.reduce((accum, next) => accum + next);
    let moy = sum / tab.length;
    return `La moyenne est de ${moy.toFixed(1)} / 20`;
}

function choiceFixe(msgNote){
    let response = "";
    let msgNumberFixe = 'Combien de note ?'
    let numberNote = Number(prompt(msgNumberFixe));
    numberNote = controlNumber(numberNote, msgNumberFixe);
    let tabNote =  [];
    alert('Début de saisie !')
    for (let i = 0; i < numberNote; i++) {
        let note = Number(prompt(msgNote));
        note = controlNumber(note, msgNote);
        note = controlNote(note);
        tabNote.push(note);
    }
    alert('Fin de saisie !');
    console.table(tabNote);
    response = `${noteMax(tabNote)}\n${noteMin(tabNote)}\n${noteMoy(tabNote)}`;
    alert(response);
}

function choiceNegative(msgNote){
    let response = "";
    let tabNote =  [];
    alert('Début de saisie !');
    let note = Number(prompt(msgNote));
    note = controlNumber(note);
    while(note >= 0){
        note = Number(prompt(msgNote));
    if(note >= 0){
        note = controlNumber(note, msgNote);
        note = controlNote(note);
        tabNote.push(note);
    }
    }
    alert('Fin de saisie !');
    console.table(tabNote);
    response = `${noteMax(tabNote)}\n${noteMin(tabNote)}\n${noteMoy(tabNote)}`;
    alert(response);
}



function menu(){
    let msgPrompt = 'Choisir un mode de saisie :\n'+
                    '1 : Saisie fixe\n'+
                    '2 : Saisie jusqu\'à une note négative';
    let msgNote = 'Veuillez entrer une note entre 0 et 20 compris :';
    let choice = Number(prompt(msgPrompt))
    choice = controlNumber(choice, msgPrompt);

    switch(choice){
        case 1:
            choiceFixe(msgNote);
            break;
        case 2:
            choiceNegative(msgNote);
            break;
        default:
            menu();
            break;
    }
}
menu();