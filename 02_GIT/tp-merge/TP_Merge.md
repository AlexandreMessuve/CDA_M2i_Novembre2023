```bash
# créer un repo Git
git init

# Ajouter un fichier et le commiter
git add fichier.txt

git commit -m 'Ajout du fichier.txt'

# Créer une feature branch B1 à partir du premier commit
git switch -c B1

#Faire une modification du fichier et commiter 
git commit -am "Ajout de texte sur le fichier.txt"

# Merger B1 dans main de manière à avoir un commit de merge dans main
git switch main

git merge B1 --no-ff

```