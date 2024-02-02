const express = require('express');
const fs = require('fs/promises')
const path = require("path");
const router = express.Router();
const getData = async () => {
    const pathData = path.join('data', 'livres.json');
    const pathFile = path.resolve(pathData);
    try {
        const booksData = await fs.readFile(pathFile, {encoding: 'utf-8'});
        return JSON.parse(booksData);

    } catch (e) {
        console.error(e)
        return {
            code: 404,
            message: 'Data not found'
        }
    }
};

const getDataById = async (id) => {
    const data = await getData();
    if (data.code) {
        return data;
    } else {
        const dataFound = data.filter(elem => elem.id === id);
        if (dataFound.length > 0) {
            return dataFound;
        } else {
            return {code: 404, message: 'Data not found'}
        }
    }
};
const getDataByAuteur = async (auteur) => {
    const data = await getData();
    if (data.code) {
        return data;
    } else {
        const dataFound = data.filter(elem => elem.auteur === auteur);
        if (dataFound.length > 0) {
            return dataFound;
        } else {
            return {code: 404, message: 'Data not found'}
        }
    }
};
const addForm = path.join('public', 'add-book.html');
const absolutePath = path.resolve(addForm);
router.get('/add-book', (req, res) => {
    res.sendFile(absolutePath);
});
router.post('/add-book', (req, res) => {
   const book = req.body;
   if (book.auteur && book.titre){
       res.status(201).json({
           code: 201,
           message: 'Ajout avec succes'
       });
   }else{
       res.status(400).json({
           code: 400,
           message: 'Erreur lors de la creation'
       });
   }
});

const searchBook = path.join('public', 'search-book.html');
const searchPath = path.resolve(searchBook);
router.get('/search', (req, res) => {
    res.sendFile(searchPath);
})
router.post('/search', async (req, res) => {
    const search = req.body;
    const data = await getDataByAuteur(search.auteur);
    res.json(data);
});
router.get('/', async (req, res) => {
    const data = await getData();
    res.json(data);
});
router.get('/:id', async (req, res) => {
    const bookId = req.params.id;
    const data = await getDataById(parseInt(bookId));
    res.json(data);
});


module.exports = router;