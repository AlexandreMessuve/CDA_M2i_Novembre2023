function getFullName(firstname, lastname){
    //charAt qui permet de choisir la premiere lettre et toUpperCase pour la mettre en majuscule.
    //slice qui permet de commencer la chaine de caractère par la deuxième lettre et toLowerCase pour mettre tout en minuscule. 
    return `${firstname.charAt(0).toUpperCase() + firstname.slice(1).toLowerCase()}  ${lastname.charAt(0).toUpperCase() + lastname.slice(1).toLowerCase()}`;
}

console.log(getFullName(prompt('Veuillez saisir votre prénom :'), prompt('Veuillez saisir votre nom :')));