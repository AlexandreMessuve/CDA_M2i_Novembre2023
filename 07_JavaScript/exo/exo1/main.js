let message, firstname, lastname

firstname = prompt('Bonjour, bienvenue sur mon programme \n Veuillez saisir votre nom : ');
lastname = prompt('Veuillez saisir votre prénom');
message = `Bonjour ${firstname} ${lastname}`
console.log(message);
document.getElementById("response").innerText = message;
alert(message);
