```bash
# Créer un nouveau répo git
git init
# Ajouter un fichier et le commiter
touch fichier.txt
git add fichier.txt
git commit -m "mon premier commit"

# Ajouter un deuxieme fichier et le commiter
touch fichier2.txt
git add fichier2.txt
git commit -m "mon deuxieme commit"

# Vérifier l'historique (on doit avoir 2 commits)
git log

# Faire des modification sur le deuxieme fichier et le commiter
git commit -am "mon troisième commit"

# Annuler les modification du dernier commit
git reset -hard id_deuxieme_commit

# Vérifier l'historique (on doit avoir 2 commits)
git log

# Créer une branche à partir du 1er commit
git checkout id_premier_commit

git switch -c mabranche

# Faire un commit sur la branche
git commit -am "mon commit depuis ma branche"
# Vérifier l'historique de la branche (on doit avoir 2 commits)
git log

# Lister les branches (on doit avoir 2 branche main et votre branche)
git branch

# Tagger la version
git tag v0.5

# Revenir sur la branche main
git switch main

# Lister les tags (on doit avoir un tag)
git tag

# Supprimer la branche
git branch -D mabranche

# Lister les branches (on doit avoir que main)
git branch
```