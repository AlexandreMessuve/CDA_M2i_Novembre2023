import Character from "./Character.js";
import Warrior from "./Warrior.js";
import Magician from "./Magician.js";

let robin = new Character('Robin', 15, 5);

let batman = new Character('Batman', 20, 10);

let aragorn = new Warrior('Aragorn', 20, 5, 10);

let gandalf = new Magician('Gandalf', 20, 2, 5);


console.log(`${aragorn.name} vie: ${aragorn.getFullLife()}`);
robin.attack(batman);
console.log(`${batman.name} vie : ${batman.life}`);
batman.attack(robin);
console.log(`${robin.name} vie : ${robin.life}`);
gandalf.attack(aragorn);
console.log(`${aragorn.name} vie : ${aragorn.getFullLife()}`);
gandalf.heal(batman);
console.log(`${batman.name} vie : ${batman.life}`);
aragorn.attack(gandalf);
console.log(`${gandalf.name} vie : ${gandalf.life}`);