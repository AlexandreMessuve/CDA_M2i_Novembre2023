# Le CLI (Commands Line Interface ou Interface en ligne de commandes)

Le CLI, ou interface en ligne de commandes, est une méthode d'intéraction avec un ordinateur ou un système informatique en utilisant des commandes textuelles plutôt que des interfaces graphiques. Au lieu de cliquer sur des icônes et de naviguer à travers des menus, vous saisissez des commandes spécifiques dans une fenêtre de terminal pour effectuer des actions.

## Avantages du CLI

1. **Efficacité:** Le CLI peut être bien plus rapide pour accomplir des tâches spécifiques une fois que vous en maîtrisez les commandes.

2. **Automatisation:** Les scripts et les automatisations peuvent être créés ^mis facilement en utilisant les commandes CLI, ce qui est fondamental pour les tâches répétitives.

3. **Environnnements distants:** Vous pouvez utiliser les CLI pour interagir avec des systèmes distants via des connexions réseau(ssh), ce qui peut être difficile voir impossible depuis une interface graphique

4. **Précision des contrôles:** Le CLI offre souvent un contrôle plus précis sur les paramètres et les options lors de l'exécution de commandes.

## Principaux éléments du CLI:

1. **Terminal:** C'est l'interface qui vous permet de saisir des commandes. Les système d'exploitation tels que Linus, MacOS et Windows ont tous leur propre terminal.

2. **Commandes/Commands:** Ce sont des instructions que vous saisissez dans le terminal pour effectuer différentes actions. Les commandes peuvent être simples (comme `ls` pour lister les fichiers) ou complexes (`git pull origin main` pour mettre a jour un dépôt git).

3. **Options et arguments:** Les commandes peuvent être suivies d'options et d'arguments pour personnaliser leur comportement. Les options sont généralement précédées d'un tiret court (comme `-l` pour obtenir une liste détaillée) et les arguments ce sont les valeurs spécifiques que vous fournissez à la commande.

## Exemples de commandes CLI:
* `ls` (Linux/Mac) ou `dir` (Windows): Liste les fichiers et dossiers de notre répertoire courant.
* `pwd` permet de savoir le répertoire courant où l'on se trouve dans le cas où notre terminal ne l'indique pas
* `cd` change le répertoire courant.
    * On utilise `cd ..` pour revenir dans le dossier parent
    * On utilise la touche TAB pour auto-compléter les noms de fichiers/dossiers
    
* `mkdir` Crée un nouveau dossier. (par exemple: `mkdire monDossier`)
* `rm` (Linus/Mac), `rmdir` ou `del` (Windowd): Supprime les fichiers ou des dossiers.
    * L'option `-r` (récursive) ajoutée à la commandes `rm` permet de supprimer non seulement le répertoire spécifié, mais aussi tous les fichiers et sous-répertoires qu'il contient.
* `cp` (Linux/Mac) ou `copy` (windows): Copie des fichiers ou des dossiers.
    * Cette commande nécessite deux arguments:
        1. Nom du fichier ou dossier.
        2. Répertoir de la direction

* `mv` (Linux/Mac) ou `move` (windows): Déplace des fichiers ou des dossiers.
    * Cette commande nécessite deux arguments:
        1. Nom du fichier ou dossier.
        2. Répertoir de la déstination
    * Cette commande peut  aussi servir à renommer un dossier ou un fichier si mon deuxieme argument est un nom de fichier à la place d'une destination.
* `touch` (Mac/Linux) suivi du nom du fichier pour créer un fichier (attention, on n'oublie pas l'extension). On peut créer facilement plusieurs fichiers de cette façon:

```bash
# Pour créer un ou plusieur fichiers
touch fichier1.txt fichier2.txt
```
* Pour Windows (mais cela marche également sur Mac et Linux), on utilise `echo . > nomdufichier.extension`

```powershell
# Pour créer un fichier
echo . > fichier1.txt
## Pour ajouter du texte à un fichier existant
echo "texte" >> fichier1.txt
```
