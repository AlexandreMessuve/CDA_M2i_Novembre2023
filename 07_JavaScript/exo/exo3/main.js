// let message, rayon, hauteur, volume, pi;

// pi = Math.PI;
// rayon = prompt('Bonjour, bienvenue sur mon programme \n Veuillez saisir un la valeur* du rayon: ') + 
// hauteur = prompt('Veuillez saisir la valeur* de la hauteur:');
// rayon = parseFloat(rayon);
// hauteur = parseFloat(hauteur);
// volume = pi * rayon**2 * hauteur / 3;
// message = `Bonjour le volume est de ${volume.toFixed(2)} cm²`;
// console.log(message);
// document.getElementById("response").innerText = message;
// alert(message);

// let rayon = parseFloat(prompt('Bonjour, bienvenue sur mon programme \n Veuillez saisir un la valeur* du rayon: '));
// let hauteur = parseFloat(prompt('Veuillez saisir la valeur* de la hauteur:'));
// alert(`Bonjour le volume est de ${Math.PI * rayon**2 * hauteur / 3} cm²`);

alert(`Bonjour le volume est de ${Math.PI * parseFloat(prompt('Bonjour, bienvenue sur mon programme \n Veuillez saisir un la valeur* du rayon: '))**2 * parseFloat(prompt('Veuillez saisir la valeur* de la hauteur:')) / 3} cm²`);
