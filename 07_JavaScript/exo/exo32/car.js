export default class Car{
    #marque = null;
    #year = null;
    #model = null;
    #color = null;
    #createdAt = null;
    #updatedAt = null;
    #id = null;
    static #count = 0;
    constructor(){
        this.#createdAt = new Date();
        Car.#count++;
        this.#id = Car.#count;
    }

    get Marque() {
        return this.#marque;
    }
    set Marque(marque) {
        if(this.#marque){
            this.#updatedAt = new Date();
        }
        this.#marque = marque;
        
    }

    get Year() {
        return this.#year;
    }
    set Year(year) {
        if(this.#year){
            this.#updatedAt = new Date();
        }
        this.#year = year;
        
    }

    get Model() {
        return this.#model;
    }
    set Model(model) {
        if(this.#model){
            this.#updatedAt = new Date();
        }
        this.#model = model;
    }

    get Color() {
        return this.#color;
    }
    set Color(color) {
        if(this.#color){
            this.#updatedAt = new Date();
        }
        this.#color = color;
    }

    get CreatedAt(){
        return this.#createdAt.toLocaleString();
    }

    get UpdatedAt(){
        return this.#updatedAt?.toLocaleString();

        
    }
    set UpdatedAt(updatedAt){
        this.#updatedAt = updatedAt;
    }
    get Id(){
        return this.#id;
    }

    


}