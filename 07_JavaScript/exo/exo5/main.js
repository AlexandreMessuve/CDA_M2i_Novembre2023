let temperature;

temperature = Number(prompt('Veuillez entrer une température :'));

alert(temperature < 0 ? "SOLIDE" : temperature <= 100 ? "LIQUIDE" : temperature > 100 ? "GAZEUX" : "ERREUR"  );