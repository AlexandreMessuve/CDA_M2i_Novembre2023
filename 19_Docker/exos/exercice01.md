**Exercice : Manipulation de Docker avec une image Alpine et GitHub**

**Objectif :** 
Ce exercice vise à évaluer votre compréhension et votre maîtrise des commandes de base de Docker, en particulier sur l'utilisation d'une image Alpine, la récupération d'un dépôt public depuis GitHub, la modification des fichiers dans le container et la copie des résultats sur la machine locale.

**Sujet :**

1. **Prérequis :**
   - Assurez-vous d'avoir Docker installé sur votre machine.
   - Ouvrez un terminal.
   

2. **Création d'un container Alpine :**
   - Utilisez la commande Docker pour créer un container basé sur l'image Alpine.
   - Connectez-vous au shell du container nouvellement créé.

    
3. **Récupération d'un dépôt GitHub :**
   - À l'intérieur du container, utilisez la commande `git` pour cloner un dépôt public depuis GitHub (par exemple, https://github.com/votre-utilisateur/exemple-repo.git).
   - Allez dans le répertoire du dépôt cloné.
  
  
4. **Modification du contenu :**
   - À l'intérieur du container, ouvrez un fichier texte (par exemple, README.md) à l'aide d'un éditeur de texte disponible dans l'image Alpine.
   - Ajoutez une ligne de texte à votre choix et enregistrez le fichier.



5. **Copie du résultat sur la machine locale :**
   - Depuis votre terminal local, utilisez la commande Docker pour copier le fichier modifié depuis le container vers votre machine locale, dans un répertoire de votre choix.
  
   
**Reponse:** 

**2:**
j'utilise la commande suivante pour pouvoir creer mon container et 
pouvoir le lancer directement avec '-it' et pouvoir nommer le container avec '--name "nom"'
```bash
docker run -it --name "alpine-exercice01" alpine
```   
une fois dans le terminal du container alpine j'effectue les commandes suivante:
```bash
apk update
apk upgrade
apk add git
apk add nano
```
**3:**
j'utilise la commande suivante pour pouvoir voir les dossiers existants:
```bash
ls -la
```
une fois fait je me déplace dans le dossier root avec la commande suivante:
```bash
cd root/
```
  
une fois dans le dossier root je clone mon repos public gitgub avec la commande suivante:
```bash
git clone https://github.com/AlexandreMessuve/AlexandreMessuve.git
```
  
après je me déplace dans mon dossier clone avec la commande suivante:
```bash
cd AlexandreMessuve/
```

**4:**
une fois dans mon repo j'utilise la commande: 
```bash 
ls -la
```
  
j'utilise la commande suivante pour pouvoir modifier mon README.md :
```bash
nano README.md
```
  
je rajoute une ligne et je sauvegarde mon fichier
et je peux exit le container avec la commande 
```bash
exit
```
  
**5:**
une fois retourner sur mon terminal windows
j'utilise la commande suivante pour voir les containers:
```bash
docker ps -a
```
    -
  
je verifie le nom de container et je recupère l'id pour pouvoir copier le fichier README sur pc local avec la commande suivante:
```bash
docker cp c3984:/root/AlexandreMessuve/README.md .\Desktop\
```
maintenant j'ai mon fichier README.md sur mon bureau