const redis = require('redis');
const port = '6379';
const host = '127.0.0.1';
const client = redis.createClient(port, host);

const readline = require('readline');
const { stdin: input, stdout: output} = require('process');
const { rejects } = require('assert');
client.on('connect', (err) => {
    if(err){
        console.log(err);
    }else{
        console.log('server redis is connected\n')
        menu();
    }
}).connect();


const rl = readline.createInterface({input, output});

let menuSelector = 0;
const menuInterface = "1 pour ajouter une tache\n2 pour voir toutes les taches enregistrées\n3 pour supprimer une tache \n4 pour quitter le menu\n"


const menu = async() => {
    while (menuSelector != '4'){
        console.log(menuInterface);
        menuSelector  = await question('Votre choix: \n');
        if(menuSelector === '1'){
            console.log(await addValue());
        }
        if(menuSelector === '2'){
            console.log(await getAllValue());
        }
        if(menuSelector === '3'){
            console.log(await deleteTask());
        }
    };
}


const question = async(question) => {
    return new Promise((resolve, rejects) => {
        rl.question(question, (res) => {
            resolve(res);
        })
    })
}

const addValue = async () => {
    try{
        let index = await getTaskIndex();
        const value = await question('Ajouter une tache: \n');
        const res = await client.set(`task${index}`, value);
        if(res){
            await setTaskIndex(index+1);
            return res;
        }
    }catch(err){
        console.error(err);
    }
}


const getAllValue = async () => {
    try{
        let index = await getTaskIndex();
        let task = "";
        for (let i = 0; i < index+1; i++) {
            const taskValue = await client.get(`task${i}`)
                if(taskValue){
                    task += `${i +'-'+taskValue} \n`;
                };
        }
        return task;
    }catch(err){
        console.error(err);
    }
};

const deleteTask = async() => {
    try{
        console.log(await getAllValue());
        const index = await question('Quelle index voulez vous supprimer ?\n')
        const res = await client.del(`task${index}`);
        if(res){
            let i = await getTaskIndex();
            await setTaskIndex(i-1);
            return 'Element supprimé avec succes';
        }else{
            return 'il y a eu un problème';
        }
    }catch(err){
        console.error(err);
    }
}
const setTaskIndex = async(i) => {
    try{
        await client.set('taskIndex', i);
    }catch(err){
        console.error(err);
    }
}

const getTaskIndex = async() => {
    try {
        const i = await client.get('taskIndex');
        if(!i){
            await setTaskIndex(0);
            return 0;
        }else{
            return parseInt(i);
        }
    } catch (err) {
        console.error(err)
    }
}