# Use this app with docker

## Run this command for create an image : 

```bash
docker build -t todo-node .
```

After run this :

```bash
docker run -p 3001:3001 -d todo-node
```