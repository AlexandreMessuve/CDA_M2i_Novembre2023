```bash
# créer un repo Git
git init

# Ajouter un fichier et le commiter(C1), le modifier et le commiter(C2)
git add fichier.txt

git commit -m 'Ajout du fichier.txt'

git commit -am 'ajout de texte'

# Créer une branche a partir du premier commit
git checkout id_commit1
git switch -c B1

# Faire une modification du fichier et commiter 
git commit -am "Ajout de texte sur le fichier.txt"

# Merger B1 dans main de manièreg à avoir un historique linéaire
git rebase main
# Gérer les conflit si il y en a.
git switch main
git merge B1

```