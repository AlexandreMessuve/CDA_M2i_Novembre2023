import Character from "./Character.js";

export default class Warrior extends Character{
    #armor = null;
    constructor(name, life, strenght, armor){
        super(name, life, strenght);
        this.#armor = armor;
    }
    attack(character){
        super.attack(character);
        character.life -= this.#armor;
        console.log(`${this.name} attaque ${character.name} et inflige ${this.strenght+this.#armor} dégats`);
    }

    getFullLife(){
        return super.life + this.#armor;
    }

    get armor(){
        return this.#armor;
    }

    set armor(armor){
        this.#armor = armor;
    }
}