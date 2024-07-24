# Exercice 7

Comme pour l'exercice 6 on souhaite cree un dockerfile mais qui cette fois-ci ira cherche le projet web sur github si vous n'avez pas de repo public contenant un projet web vous pouvez utilise https://github.com/withaarzoo/3D-Rotate-Tube .

```dockerfile
FROM httpd

LABEL version="1.0"

RUN apt update && apt upgrade -y && apt install git -y

WORKDIR /usr/local/apache2/htdocs

RUN git clone https://github.com/AlexandreMessuve/le-prix-juste-game.git && mv ./le-prix-juste-game/* ./ && rm -r ./le-prix-juste-game

EXPOSE 80

CMD [ "httpd-foreground" ]
```

```bash
docker build -t le-prix-juste-jeu .
docker run -p 8000:80 --name le-juste-prix -d le-prix-juste-jeu
```
```bash
docker tag le-prix-juste-jeu alexandremessuvem2i/le-prix-juste-jeu:1.0
docker push alexandremessuvem2i/le-prix-juste-jeu:1.0
```
[Image my website nginx](https://hub.docker.com/r/alexandremessuvem2i/le-prix-juste-jeu)