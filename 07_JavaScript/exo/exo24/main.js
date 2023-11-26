function choiceMenu(choice, menu = 1, tabContact, msg, fonction1, fonction2) {
    while (choice !== 0) {
        choice = Number(prompt(msg));
        switch (choice) {
            case 0:
                if (menu === 1)
                    return;
                else
                    return tabContact;

            case 1:
                tabContact = menu === 1 ? fonction1() : fonction1(tabContact);
                alert(tabContact);
                break;

            case 2:
                tabContact = fonction2(tabContact);
                if (menu === 2) alert(tabContact);
                break;

            default:
                alert('Erreur de saisie');
                break;
        }
    }
}

function seazureContact() {
    let tabContact = [];

    let lengthTab = Number(prompt('Combien de contact voulez-vous saisir ?'));

    for (let i = 0; i < lengthTab; i++) {
        let contact = prompt(`Saisir le contact n°${i + 1} :`);
        tabContact.push(contact);
    }
    return tabContact;
}

function menuShowContact(tabContact) {
    let msg = '0 : Revenir au menu principal\n' +
        '1 : Trier par ordre alphabéthique\n' +
        '2 : Mélanger aléatoirement les contacts';
    let choice;
    tabContact = choiceMenu(choice, 2, tabContact, msg, tabSortAlpha, tabSortRandom)
    menu(tabContact);
}

function tabSortAlpha(tabContact) {
    return tabContact.sort();
}
function tabSortRandom(tabContact) {
    for (let i = tabContact.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [tabContact[i], tabContact[j]] = [tabContact[j], tabContact[i]];
    }
    return tabContact;
}
function menu(tabContact) {
    let msg = '0 : Quitter le menu\n' +
        '1 : Resaisir contact\n' +
        '2 : Afficher les contacts';
    let choice;
    tabContact = choiceMenu(choice, 1, tabContact, msg, seazureContact, menuShowContact);
    alert('Aurevoir !!!')
}
let tab = seazureContact();

console.table(tab);

menu(tab);

