let message, number1, number2, resultas;

number1 = prompt('Bonjour, bienvenue sur mon programme \n Veuillez saisir un premier nombre : ');
number2 = prompt('Veuillez saisir un deuxième nombre');
resultas = parseInt(number1) + parseInt(number2);
message = `Bonjour l'addition ${number1} + ${number2} = ${resultas}`;
console.log(message);
document.getElementById("response").innerText = message;
alert(message);
