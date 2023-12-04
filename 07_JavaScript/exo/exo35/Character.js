export default class Character{
    name = null;
    life = null;
    strenght = null;

    constructor(name, life, strenght){
        this.name = name;
        this.life = life;
        this.strenght = strenght;
    }

    attack(character){
        character.life -= this.strenght;
        console.log(`${this.name} attaque ${character.name} et inflige ${this.strenght} dégats`)
    }
    
    set name(name){
        this.name = name;
    }

    get name(){
        return this.name;
    }

    set life(life){
        this.life = life;
    }

    get life(){
        return this.life;
    }

    set strenght(strenght){
        this.strenght = strenght;
    }

    get strenght(){
        return this.strenght;
    }
};