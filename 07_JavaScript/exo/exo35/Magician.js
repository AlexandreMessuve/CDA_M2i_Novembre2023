import Character from "./Character.js";

export default class Magician extends Character{
    #mana = null;
    constructor(name, life, strenght, mana){
        super(name, life, strenght);
        this.#mana = mana;
    }
    attack(character){
        super.attack(character);
        character.life -= this.#mana;
        console.log(`${this.name} attaque ${character.name} et inflige ${this.#mana} dégats`);
    }

    heal(character){
        character.life += this.#mana;
        console.log(`${this.name} a soigné ${character.name} de ${this.#mana} points de vie`)
    }
    get mana(){
        return this.#mana;
    }

    set mana(mana){
        this.#mana = mana;
    }
}