function subtract(a, b){
    console.log(`Je soustrais ${a} et ${b}`)
    return a - b;
}

let num1 = Number(prompt('Veuillez saisir un premier nombre :'));
let num2 = Number(prompt('Veuillez saisir un second nombre :'));
while(isNaN(num1)){
    num1 = Number(prompt('Ce n\'est pas un entier.\nVeuillez resaisir un premier nombre :'));
}
while(isNaN(num2)){
    num2 = Number(prompt('Ce n\'est pas un entier.\nVeuillez resaisir un second nombre :'));
}
let result = subtract(num1, num2);
console.log(result);