const redis = require('redis');
const port = '6379';
const host = '127.0.0.1';
const client = redis.createClient(port, host);
const Product = require('./class/Product.js');

const readline = require('readline');
const { stdin: input, stdout: output } = require('process');

client.on('connect', (err) => {
    if (err) {
        console.log(err);
    } else {
        console.log('server redis is connected\n')
        menu();
    }
}).connect();


const rl = readline.createInterface({ input, output });

let menuSelector = 0;
const menuInterface = "1 pour ajouter un produit\n2 pour mettre le stock d'un produit\n3 afficher les stocks\n4 supprimer un produit\n5 quitter\n"


const menu = async () => {
    while (menuSelector != '5') {
        console.log(menuInterface);
        menuSelector = await question('\nVotre choix: \n');
        if (menuSelector === '1') {
            console.log(await addProduct());
        }
        if (menuSelector === '2') {
            console.log(await updateProduct());
        }
        if (menuSelector === '3') {
            console.log(await getProductStock());
        }
        if (menuSelector === '4') {
            console.log(await deleteProduct());
        }
        if (menuSelector === '5') {
            console.log('\n---Fin du programme---\n')
        }
    };
}


const question = async (question) => {
    return new Promise((resolve, rejects) => {
        rl.question(question, (res) => {
            resolve(res);
        })
    })
}

const addProduct = async () => {
    try {
        console.log('\nAjouter un produit: \n')
        const name = await question('\nSaisir le nom du produit \n');
        const stock = await question('\nSaisir la quantité du produit \n');
        const price = await question('\nSaisir le prix du produit \n');

        let prod = new Product(name, stock, price);
        const res = await client.rPush('products', JSON.stringify(prod));
        if (res) {
            return 'ajouter avec succes'
        } else {
            return 'une erreur est survenue';
        }
    } catch (err) {
        console.error(err);
    }
}

const getAllProduct = async () => {
    try {
        return await client.lRange('products', 0, -1);
    }
    catch (err) {
        return err;
    }
}
const getProductStock = async () => {
    try {
        const products = await getAllProduct();
        let response = '';
        if (products.length > 0) {
            console.log('liste des stocks\n')
            products.forEach((product) => {
                const prod = JSON.parse(product);
                console.log(`|name: ${prod.name}, stock: ${prod.stock}|\n`);
            })
        } else {
            response = 'Aucun produit enregistré en bdd\n'
        }
        return response;
    } catch (err) {
        return err;
    }
};

const updateProduct = async () => {
    try {
        const products = await getAllProduct();
        if (products.length > 0) {
            products.forEach((product) => {
                const prod = JSON.parse(product);
                console.log(`id: ${prod.id}, name: ${prod.name}\n`);
            });

            console.log('Quelle produit voulez vous modifier ?\n')
            const id = await question('Veuillez saisir l\'id: \n');
            let findProduct,findIndex;
            products.forEach((product, index) => {
                const prod = JSON.parse(product);
                if (prod.id == parseInt(id)) {
                    findIndex = index;
                    findProduct = prod;
                }
            });

            if (findIndex !== undefined && findProduct !== undefined) {
                const newName = await question('Nouveau nom (vide si aucun changement) : ');
                const newStock = await question('Nouveau stock (vide si aucun changement) : ');
                const newPrice = await question('Nouveau price (vide si aucun changement) : ');

                if (newName.length > 0) {
                    findProduct.name = newName;
                }
                if (newStock.length > 0) {
                    findProduct.stock = newStock;
                }
                if (newPrice.length > 0) {
                    findProduct.price = newPrice;
                }

                if (await client.lSet('products', indexProd, JSON.stringify(findProduct))) {
                    return 'Modifié avec succes\n';
                } else {
                    return 'Erreur lors de la modification du produit \n';
                }
            }

        } else {
            return 'Aucun produit dans la bdd\n'
        }
    } catch (err) {
        return err;
    }
}


const deleteProduct = async () => {
    try {
        const products = await getAllProduct();
        if (products.length > 0) {
            products.forEach((product) => {
                const prod = JSON.parse(product);
                console.log(`id: ${prod.id}, name: ${prod.name}\n`);
            });

            console.log('Quelle produit voulez vous supprimer ?\n')
            const id = await question('Veuillez saisir l\'id: \n');
            let findProduct, findIndex;
            products.forEach(async (product, index) => {
                const prod = JSON.parse(product);
                if (prod.id == parseInt(id)) {
                    findIndex = index;
                    findProduct = prod;
                }
            });
            if (findIndex !== undefined && findProduct !== undefined) {
                if (await client.lRem('products', -1, JSON.stringify(findProduct))) {
                    return 'le produit a bien été supprimé\n';
                } else {
                    return 'une erreur est survenu lors de la suppression\n';
                }
            } else {
                return 'aucun produit sous cet id\n'
            }


        } else {
            return 'Aucun produit dans la bdd\n'
        }
    } catch (err) {
        return err;
    }
}
