```bash
# Créer un nouveau répo git
git init
# Ajouter un fichier et le commiter
touch fichier.txt
git add fichier.txt
git commit -m "mon premier commit"

# Modifier le fichier et le commiter
git commit -am "mon deuxieme commit"

# Observer l'historique (on doit avoir 2 commits)
git log
```