let age, paid, yearExp, condition, reason;


age = Number(prompt('Veuillez entrer votre age :'));

paid = Number(prompt('Veuillez entrer votre salaire : '));

yearExp = Number(prompt('Veuillez entrer vos années d\'expérience'));

condition = age >= 30 && paid <= 40000 && yearExp >= 5;

//version if 
if(condition){
    console.log("vous êtes éligible pour postuler.");
}else{
    if(age < 30){
        reason = "Vous etes trop jeune. ";
    }
    if(paid > 40000){
        reason += "Votre salaire est trop élévé. ";
    }
    if(yearExp < 5){
        reason += "Vous n'avez pas l'expérience requise. ";
    }
    console.log("Vous n'êtes pas éligible. Raison: "+reason );
}

//version terniaire

console.log(condition ? "Vous etes eligible" : "Vous n'êtes pas éligible raison: " + (age < 30 ? "Vous êtes trop jeune. \n" : "")+(paid > 40000 ? "Votre salaire est trop élevé. \n" : "\n")+(yearExp < 5 ? "Vous n'avez pas l'expérience requise. " : "") );
