class Circle{
    constructor(rayon){
        this.rayon = rayon
    }

    perimetre(){
        return  2 * Math.PI * this.rayon;
    }

    aire(){
        return Math.PI * (this.rayon**2);
    }
}

module.exports = Circle;