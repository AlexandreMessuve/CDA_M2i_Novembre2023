//soustraction
function subtract(a, b) {
    console.log(`Je soustrais ${a} et ${b}`)
    return a - b;
}

function exoSubstract() {
    let num1 = Number(prompt('Veuillez saisir un premier nombre :'));
    while (isNaN(num1)) {
        num1 = Number(prompt('Ce n\'est pas un entier.\nVeuillez resaisir un premier nombre :'));
    }
    let num2 = Number(prompt('Veuillez saisir un second nombre :'));
    while (isNaN(num2)) {
        num2 = Number(prompt('Ce n\'est pas un entier.\nVeuillez resaisir un second nombre :'));
    }
    let result = subtract(num1, num2);
    console.log(result);
}

function getHours(hours = "12h00") {
    console.log(`il est ${hours}`);
}
//hours
function hours() {
    getHours();

    let hours = "15h00";

    getHours(hours);
}

//exo 18
let isPalindrome = (string) => {
    let lengthString = string.length;
    string = string.trim().toLowerCase();
    for (let char = 0; char < lengthString / 2; char++) {
        if (string[char] !== string[lengthString - 1 - char]) {
            return false;
        }
    }
    return true;
}

function palindrome() {
    let str = prompt('Veuillez saisir une phrase ou un mot.');

    if (isPalindrome(str)) {
        console.log(`${str} est palindrome`)
    } else {
        console.log(`${str} n'est pas palindrome`)
    }
}

//exo 19
function cptLetterA(string) {
    let cptA = 0;
    length = string.length;
    string = string.toLowerCase();
    for (let char = 0; char < length; char++) {
        if (string[char] === 'a') {
            cptA++
        }
    }
    return cptA;
}

function letterA() {
    let string = prompt('Veuillez saisir votre un mot ou une phrase');

    let numA = cptLetterA(string);

    console.log(`Il y a ${numA} "a" dans ${string}`);
}
//exo20
function isVerifAdn(string) {
    string = string.toLowerCase();
    const length = string.length;
    for (let char = 0; char < length; char++) {
        if (
            (string[char] !== 'a') &&
            (string[char] !== 't') &&
            (string[char] !== 'c') &&
            (string[char] !== 'g')
        ) {
            return false;
        }
    }
    return true;
}

function inputAdn(string, message) {
    while (!isVerifAdn(string)) {
        console.log('Erreur de saisie !!!');
        string = prompt(`Saisir la ${message} : `);
    }
    return string.toLowerCase();
}

function proportion(string, sequence) {
    let cpt = 0;
    const lengthString = string.length;
    const lengthSequence = sequence.length;
    for (let char = 0; char < lengthString; char++) {
        if (string.substring(char, char + lengthSequence) !== sequence) {
            continue;
        }
        cpt++;
    }
    return (cpt * lengthSequence) * 100 / lengthString;
}

function adn() {
    let string = prompt('Saisir la chaine : ');

    string = inputAdn(string, "chaine");

    let sequence = prompt('Saisir la séquence : ');

    sequence = inputAdn(sequence, "séquence");

    console.log(`chaine : ${string}\nséquence: ${sequence}`);

    let pourcent = proportion(string, sequence);
    console.log(`Il y a ${pourcent.toFixed(1)}% de "${sequence}" dans la chaine "${string}"`);
}
function menu() {
    let message =
        'Bienvenue sur le menu des exercices.\n' +
        'Tapez 0 - Quitter\n' +
        'Tapez 1 - Soustraction \n' +
        'Tapez 2 - Heures\n' +
        'Tapez 3 - Palindrome\n' +
        'Tapez 4 - Lettre A\n' +
        'Tapez 5 - ADN\n'
    let menu = Number(prompt(message));
    while (menu != 0) {
        switch (menu) {
            case 1:
                exoSubstract();
                break;
            case 2:
                hours();
                break;
            case 3:
                palindrome();
                break;
            case 4:
                letterA();
                break;
            case 5:
                adn();
                break;
            default:
                alert('Saisie non valide');
                break;
        }
        menu = Number(prompt(message));
    }
    alert('Aurevoir');
}

menu();