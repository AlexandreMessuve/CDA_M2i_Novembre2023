function validateMail(email){
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\.[a-zA-Z]{2,}$/;
    return pattern.test(email);
}

let tabEmail = ["user@example.com",
    "john.doe123@example.co.uk",
    "alice_smith@company.net",
    "bob+jones@email.org",
    "contact@website.info",
    "user@example",
    "john.doe@.co.uk",
    "alice@company@net",
    "bob@jones@email.org",
    "contact@website."];

const map = tabEmail.map((email) =>  email = validateMail(email));

console.table(map);
alert(map);
