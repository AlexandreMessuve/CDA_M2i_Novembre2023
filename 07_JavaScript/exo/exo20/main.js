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

function inputAdn(string) {
    while (!isVerifAdn(string)) {
        console.log('Erreur de saisie !!!');
        string = prompt('Saisir la chaine : ');
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

let string = prompt('Saisir la chaine : ');

string = inputAdn(string);

let sequence = prompt('Saisir la séquence : ');

sequence = inputAdn(sequence);

console.log(`chaine : ${string}\nséquence: ${sequence}`);

let pourcent = proportion(string, sequence);
console.log(`Il y a ${pourcent.toFixed(1)}% de "${sequence}" dans la chaine "${string}"`);