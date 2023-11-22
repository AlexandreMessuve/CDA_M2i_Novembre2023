let n = Number(prompt('Veuillez saisir N : '));
let result = "";
let somme = 0;
let max = (n / 2) + 1;
flag = false;

// première version
for (let i = 1; i <= max; i++) {
    for (let j = i; j <= max; j++) {
        somme += j;
        if (somme === n) {
            for (let h = i; h <= j; h++) {
                if (h === i) {
                    result += `${n} = ${h} + `;
                } else if (h != j) {
                    result += `${h} + `;
                } else {
                    result += `${h}\n`;
                }
            }
            flag = true;
        }
        if (flag) {
            flag = false;
            break;
        }
    }
    somme = 0;
}

console.log(`${result}`);
result = "";
//Seconde version
for (let i = 1; i <= max; i++) { 
    let sommeTemp = '';
    for (let j = i; j <= max; j++) {
        somme += j;
        sommeTemp += j !== i ? ` + ${j}` : `${j}`;
        if(somme > n) break;
        if (somme === n) {
            result += `${n} = ${sommeTemp}\n`;
            break;
        }
    }
    somme = 0;
}

console.log(result);