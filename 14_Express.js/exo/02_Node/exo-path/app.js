import path from 'path';


const filePath = path.join('documents', 'rapport.txt');
console.log(filePath);
const absolutPath = path.resolve(filePath);
console.log(absolutPath);
const extFile = path.extname(absolutPath);
console.log(extFile);
if(extFile === '.txt'){
    const dirname = path.dirname(absolutPath);
    console.log(dirname);
    const basename = path.basename(absolutPath);
    console.log(basename);
    const fullPath = path.parse(absolutPath);
    console.log(fullPath);
    const normalizePath = path.normalize(absolutPath);
    console.log(normalizePath);
}else {
    console.log('ext name is not .txt')
}