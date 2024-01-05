class Product {
    id;
    name;
    stock;
    price;
    static count = 0;

    constructor(name,stock,price){
        Product.count++;
        this.id = Product.count;
        this.name = name;
        this.stock = stock;
        this.price = price;
    };

    set name (name){
        this.name = name;
    }

    get name () {
        return this.name;
    }

    set stock(stock) {
        this.stock  = stock;
    }

    get stock() {
        return this.stock;
    }
    set price(price){
        this.price = price;
    }
    get price(){
        return this.price;
    }

}

module.exports = Product;