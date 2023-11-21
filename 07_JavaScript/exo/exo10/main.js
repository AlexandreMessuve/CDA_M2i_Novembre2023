let triangleHeigth = Number(prompt('Veuillez saisir la hauteur du triangle : '));
let numberSpace = triangleHeigth;
let space = " ";
let star = "*";
let tree = "";
for (let i = 1; i <= triangleHeigth; i++) {
    tree += `${space.repeat(numberSpace)}${star.repeat(i === 1 ? i : (i * 2) - 1)}\n`;
    numberSpace--;
}

console.log(tree);

//le sapin avec des boules ouais
let boule = "O";

let chrismasTree = "";
numberSpace = triangleHeigth;
for (let i = 1; i <= triangleHeigth; i++) {
    let row = "";

    if (i > 1) {
        for (j = 1; j <= i + 1; j++) {
            if (Math.random() < 0.5) {
                row += `%c${star}`
            } else {
                row += `%c${boule}`
            }
        }
    }



    chrismasTree += `${space.repeat(i === 1 ?numberSpace+2: numberSpace)}${i === 1 ? `%cA` : row}\n`;
    numberSpace--;
}
console.log(chrismasTree);