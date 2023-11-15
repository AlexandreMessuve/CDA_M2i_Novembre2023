```bash
# créer un repo Git
git init

# Ajouter un fichier et le commiter(C1), le modifier et le commiter(C2)
git add fichier.txt

git commit -m 'C1'

git commit -am 'C2'

# Créer une branche B1 à partir de C1
git checkout id_commit1
git switch -c B1

# Faire une modification du fichier et commiter 
git commit -am "C3"

# Merger B1 dans main en résolvant les conflits
git switch main
git merge B1

```