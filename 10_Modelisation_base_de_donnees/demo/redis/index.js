import redis from 'redis';

const host = "127.0.0.1";
const port = '6379';

const client = redis.createClient(port, host);

client.on('connect', (err) => {
    if(err){
        console.log(err)
    }else{
        console.log('connected to redis')
    }

}).connect();


await client.set('key1', 'flo');

try{
    const value1 = await client.get('key1');
    console.log(value1);
}catch(err){
    console.log(err)
}
