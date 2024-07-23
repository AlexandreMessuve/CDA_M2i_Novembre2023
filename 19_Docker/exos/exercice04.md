# Exercice 4

## Partie 1

- En utilisant votre machine Windows, lancez le service Docker, s’il n’est pas lancé.

- Créer une image Docker sur votre machine du jeu 2048 (voir screen jeux_2048).

- Vérifier que l’image est bien présente sur votre machine.

- Lancer ce jeu sur un port disponible au travers d’un conteneur que vous allez appeler «jeu-votre-nom ». 

- Vérifier que le conteneur est bien lancé avec la commande adaptée.

- Créer un second conteneur qui va lancer le même jeu mais avec un nom différent «jeu2-votre-nom ».

- Les 2 jeux sont fonctionnels en même temps sur votre machine, effectuez la commande pour vérifier la présence des conteneurs.

- Ouvrez les 2 jeux sur votre navigateur. 

- Stopper les 2 conteneurs et assurez-vous que ces 2 conteneurs sont arrêtés.

- Relancez le conteneur «jeu2-votre-nom » et aller vérifier dans votre navigateur s’il fonctionne bien. Effectuez la commande pour voir s’il a bien été relancé. Puis stopper le. 

- Supprimez l’image du jeu 2048 et les conteneurs associés.

- Vérifiez que les suppressions ont bien été faite.


## Partie 2


- Récupérer une image docker nginx.

- Créer un conteneur en vous basant sur cette image en lui attribuant le nom suivant : « nginx-web».

- Assurez-vous que l’image est bien présente et que le conteneur est bien lancé.

- Ce serveur nginx web (nginx-web) devra être lancé sur un port disponible.

- Vérifier que le serveur est bien lancé au travers du navigateur.

- Une page web avec «Welcome to nignx » devrait s'afficher (voir nginx.png). 

- Effectuer la commande vous permettant de rentrer à l’intérieur de votre serveur nginx.

- Une fois à l’intérieur, aller modifier la page html par défaut de votre serveur nginx en changeant le titre de la page en :  
Welcome «votre prenom ».

- Relancez votre serveur et assurez-vous que le changement à bien été pris en compte, en relançant votre navigateur.

- Refaite la même opération mais en utilisant le serveur web apache et donc il faudra créer un autre conteneur.

- Il faut supprimer le contenu complet de l'index.html et y mettre : "Je suis heureux et je m'appelle votre prenom".

- Le changement doit appaître dans votre navigateur.

## Partie 3


- Répétez 3 fois la même opération que pour le début de la partie 2, il faudra juste appelez vos conteneurs :

- « nginx-web3 ».

- « nginx-web4 ».

- « nginx-web5 ».

- Il faudra faire en sorte que les pages html présente dans les fichiers ci-dessous s’affiche dans chacun des navigateurs en lien avec vos conteneurs :

- html5up-editorial-m2i.zip pour nginx-web3

- html5up-massively.zip pour nginx-web4

- html5up-paradigm-shift.zip pour nginx-web5

- Stopper, ensuite, ces différents conteneurs.


```bash
#partie 1
docker search 2048
docker pull kubespheredev/2048
docker images kubespheredev/2048

docker run --name 2048-jeu-alex -p 8081:80 -d kubespheredev/2048
docker ps

docker run --name 2048-jeu2-alex -p 8082:80 -d kubespheredev/2048

docker stop 2048-jeu-alex 2048-jeu2-alex

docker start 2048-jeu2-alex
docker ps
docker stop 2048-jeu2-alex

docker rm 2048-jeu-alex 2048-jeu2-alex
docker ps -a
docker rmi kubespheredev/2048
docker images kubespheredev/2048

#partie 2
docker search nginx
docker pull nginx

docker run -p 8081:80 -d --name nginx-web nginx
docker images nginx
docker ps

docker exec -it nginx-web sh #ou bash

apt update
apt upgrade -y
apt install nano -y

cd /usr/share/nginx/html
nano index.html
exit

docker stop nginx-web
docker start nginx-web

docker search apache

docker pull httpd

docker run -p 8082:80 --name apache-web -d httpd

docker exec -it apache-web bash # ou sh

ls
cd htdocs
nano index.html
exit

#partie 3
docker run -p 8083:80 -d --name nginx-web3 nginx
docker run -p 8084:80 -d --name nginx-web4 nginx
docker run -p 8085:80 -d --name nginx-web5 nginx
docker ps

docker cp C:\Users\Administrateur\Downloads\html5up-editorial-m2i.zip nginx-web3:/usr/share/nginx/html
docker exec -it nginx-web3 bash # ou sh
apt update
apt upgrade -y
apt install unzip -y
cd /usr/share/nginx/html
rm 50x.html index.html
unzip html5up-editorial-m2i.zip
ls
mv ./html5up-editorial/* ./
ls
rm html5up-editorial-m2i.zip
rm -r html5up-editorial
exit

docker cp C:\Users\Administrateur\Downloads\html5up-massively.zip nginx-web4:/usr/share/nginx/html
docker exec -it nginx-web4 bash # ou sh
apt update
apt upgrade -y
apt install unzip -y
cd /usr/share/nginx/html
rm 50x.html index.html
unzip html5up-massively.zip
ls
rm html5up-massively.zip
exit

docker cp C:\Users\Administrateur\Downloads\html5up-paradigm-shift.zip nginx-web5:/usr/share/nginx/html
docker exec -it nginx-web5 bash # ou sh
apt update
apt upgrade -y
apt install unzip -y
cd /usr/share/nginx/html
rm 50x.html index.html
unzip html5up-paradigm-shift.zip
ls
rm html5up-paradigm-shift.zip
exit

docker stop nginx-web3 nginx-web4 nginx-web5
```