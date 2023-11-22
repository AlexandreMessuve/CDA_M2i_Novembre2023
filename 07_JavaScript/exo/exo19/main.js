function cptLetterA(string){
    let cptA = 0;
    length = string.length;
    string = string.toLowerCase();
    for (let char = 0; char < length; char++) {
        if(string[char] === 'a'){
            cptA++
        }
    }
    return cptA;
}

let string = prompt('Veuillez saisir votre un mot ou une phrase');

let numA = cptLetterA(string);

console.log(`Il y a ${numA} "a" dans ${string}`);