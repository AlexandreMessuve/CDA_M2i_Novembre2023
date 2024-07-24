# Exercice 6

On souhaite cree une imge docker pour distribue notre site web statique via un serveur web

- Choisir une image de serveur web

- Cree un dockerfile a partir de cette image qui a la place de sa page par défaut montrera votre projet
```dockerfile
FROM nginx

LABEL version="1.0"

WORKDIR /usr/share/nginx/html

COPY ./exo_site/. .

EXPOSE 80

CMD [ "nginx", "-g", "daemon off;" ]
```
- Vous notere la commande pour teste votre image 
```bash
docker build -t my-website-nginx .
docker run -p 8000:80 --name mywebsite -d my-website-nginx
```
Bonus :

- Vous publierez cette image sur docker hub 
```bash
docker tag my-website-nginx alexandremessuvem2i/my-website-nginx:1.0
docker push alexandremessuvem2i/my-website-nginx:1.0
```
[Image my website nginx](https://hub.docker.com/r/alexandremessuvem2i/my-website-nginx)
