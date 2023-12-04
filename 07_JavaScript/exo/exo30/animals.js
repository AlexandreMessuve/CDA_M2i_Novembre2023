export class Dog{
    race;
    name;
    year;
    color;
    type = 'dog';
    constructor(race, name, year, color){
        this.race = race;
        this.name = name;
        this.year = year;
        this.color = color;
    }
    
}

export class Cat{
    race;
    name;
    year;
    color;
    type = 'cat';
    constructor(race, name, year, color){
        this.race = race;
        this.name = name;
        this.year = year;
        this.color = color;
    }
}

//Race des chats
export const catRace = [
    "Persan",
    "Siamois",
    "Maine Coon",
    "Bengal",
    "Scottish Fold",
    "Européen"
];

//Race des chiens
export const dogRace = [
    "Labrador",
    "Chiwawa",
    "Jack Russel",
    "Fox Terrier",
    "Chien Saucisse",
    "Croisé"
]