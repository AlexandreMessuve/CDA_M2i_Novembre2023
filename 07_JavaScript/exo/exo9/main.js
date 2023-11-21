let userNumber = Number(prompt("Mettez le nombre de table de multiplication que vous voulez avoir :"));
let calcul;


// premier affichage

for (let i = 1; i <= userNumber; i++) {

    console.log(`Table de ${i} : \n`);

    for (let j = 1; j <= 10; j++) {

        calcul = i + j;

        console.log(`${i} x ${j} = ${calcul} \n`);

    }
}

let message = "";
let underscore = "";
// second affichage
for (let i = 1; i <= 10; i++) {
    let number = `${i}`;

    let under = "-----";

    message += `${number.padStart(5)}`;

    underscore += under.padStart(3);
}
console.log(`${message}\n ${underscore}`);
for (let i = 1; i <= userNumber; i++) {
    message = "";
    for (let j = 1; j <= 10; j++) {
        calcul = `${i * j} `;
        message += `${calcul.padStart(5)}`;
    }
    console.log(message);
}

console.log(underscore);