## Apprendre à utiliser GIT

Git est un système de contôle de version distribué(dvcs) largement utilisé dans le développement de logiciels et d'autres projets collaboratifs. Il permet de suivre, gerer et enregistrer les modifications apportées à un ensemble de fichiers au fil du temps, tout en facilitant la collaboration entre les membres d'une équipe. Conçu en 2005 par Linus Torvalds, Git est conçu pour être rapide, efficace et décentralisé.

Git agit comme un système de suivi des modifications qui enregistre chacune des modification, ajout ou suppression de fichiers dans un historique organisé. Il permet aux développeur de travailler en paralèlle sur différentes fonctionnalités ou branches de projet, de fusionner leurs contributions et de revenir en arrière en cas de besoin. Cette approche facilite la gestion de projets complexe et la préservation d'un historique complet des évolutions du code sources.

Git fonctionne en conservant les instantanés (commits) de l'état des fichiers à différents moments. Ces commits sont organisés en une séquence chronologie et peuvent être révisés, fusionnés et partagé avec d'autres membres de l'équipe.

Git est souvent utilisé conjointement avec des platforme de gestion de code source en ligne telles que Github, GitLab, Azure ou BitBucket, qui permettent un stockage distant des dépôts Git et la collaboration simplifiée.

## Installer Git

Pour pouvoir être utilisé, Git nécessite d'être installé sur votre OS, vous pouvez trouver les installateurs sur le site officiel: 
[Télécharger Git](https://git-scm.com/download)

Git est compatible avec MacOS, Linux et Windows.

## Premiers pas

Git peut être utilisé via CLI ou via une interface graphique (comme celle de VSCode par exemple). On privilégiera toutefois le CLI pour sa polyvaence et sa rapidité.  
En CLI, toutes les commandes de git commencent par le mot-clé git (par exemple `git init`).

## Configurer son compte Git

`git config` est un outil qui permet de voir et modifier les variables de configuration qui contrôlent tous les aspects de l'apparence et du comportement de Git.  
On va d'abord s'en servir pour configurer son compte:
```bash
git config --global user.name "Alexandre MESSUVE"
git config --global user.email "alexandre.messuves@gmail.com"
```

### Obtenir de l'aide
-Pour obtenir la documentation lier a une commande, il suffit d'uiliser l'une des commandes suivantes:
```bash
git help "nom de la commande"
git 'commande' --help
```

Par exemple, pour obtenir l'aide de la commande config: `git help config`
Pour une documentation plus concise: `git config -h`

## Initialiser un dépôt Git (Working Directory)

Pour commencer a suivre les modifications d'un projet, vous devez créer un dépôt Git. Vous pouvez le faire en exécutant la commande suivant **dans le répertoire de votre projet**
```bash
git init
```

Si votre dépôt a bien été généré, un fichier **.git** est aparu dans le répertoire courant. Pour supprimer ce dépôt, il suffit de supprimer ce fichier **.git**
```bash
rm -rf .git
```

## Le staging (indexage)

Le staging, également appelé indexage, est une étape intermédiaire essentielle lors de l'utilisation de Git. C'est le mécanisme qui vous permet de préparer soigneusement les modifications que vous souhaitez inclure dans votre prochain commit.  
Je peux ajouter les fichiers que je souhaite a mon commit grâce a la commande `git add "nom du fichier"`.

Si je souhaite suivre tous les fichiers présents dans mon dépôt, j'utiliserai `git add .`

Pour afficher la liste des fichiers qui sont actuellement en staging (indexés) et prêts à être inclus dans le prochain commit, vous pouvez utilisé la commande `git status`.

Pour retirer un fichier de la staging area (zone d'indexage) sans annuler les modification apportées au fichier, vous pouvez utiliser `git rm --cached "nomdufichier"`.

```bash
git rm --cached fichier.txt
```

## Créer notre instantané (commit)

Lorsque mes fichiers surveillés sont prêts dans la staging area, je peux prendre à tout moment un instantané (commit) de leur état. Ce commit agira comme uune sauvegarde à laquelle je pourrais réaccéder quand je le souhaite. La commande est simplement `git commit`.

Cela nous ouvre un editeur de texte pour que nous puissions indiquer le nom de notre commit.

---
L'éditeur de texte utilisé de base par Git est Vim. C'est un éditeur très ancien dont l'ergonomie peut être difficile à apprehender au début. Voici les seules commandes qui vous seront utiles pour écrire un commit:

* Par défault, nous ne sommes pas en mode insetion de caractères, pour entrer dans ce mode, il faut appuyer sur la touche `a` ou la touche `i`, le mode dans le quel vous vous trouvez est spécifié en bas de vote terminal
* Nous pouvons maintenant écrire le nom de notre choix en première ligne du fichier.  
Pour quitter ce mode insertion ou n'importe quel autre mode, on appuie sur la touche `echap`.

* En dehors du mode insertions, je peux écrire des lignes de commandes, si je les commence par le caractère `:` (deux points). Voici les différentes commandes que vous pouvez utiliser pour quitter l'éditeur:
    * `:q` (quit). Cette commande quitte vim mais uniquement si aucun changement n'a été apporté au document. Si c'est le cas, Vim nous indiquera un message d'erreur. **Si le fichier est quitté étant vide, le commit est annulé**
    * `:ql` (force quit). Quitte l'éditeur meme si des ont été apportés. Ceux la seront définitivement perdus et **le commit sera annulé**
    * `:wq` (write & quit).Vos changeents seront sauvegardés et vous quittez l'éditeur. Le commit est envoyé. Vous pouvez également utiliser le raccourci `:x`

---
Pour de très longs noms, cela pourra servir mmais de manière générale nous préférons ajouter l'option `-m` (pour message) à notre commande de commuit pour indiquer directement son nom en argument.
```bash
git commit -m 'nomducommit'
``` 


Si j'ajoute l'option `-a` (pour add) j'ajouterai toutes mes modifications des fichiers dèjà suivis par staging area sans avoir besoin de répéter mon `git add`, mais il n'ajoutera pas les nouveaux fichiers créés après le commit (que je devrais intégrer classiquement avec `git add`) ni ceux qui ont été supprimés.

Les options sont cumulables dans Git, par exemple:

```bash
git commit -am "nom du commit"
```

Pour voir l'historique de tous mes commits, j'utiliserai git log
```bash
git log
```

Deux options sont souvent ajoutés à `git log`:

* `-n` "nom de notre choix": limite à un nombre de *n* de commit.
* `-- oneline` : offre une version condensée en une ligne de chaque commit.

Pour voir les details spécifique d'un commit, j'utiliserai la commande `git show`
```bash
git show [id-du-commit]
```

Enfin, si je souahaite comparer deux commit, j'utilise la commande `git diff` sur leurs identifiants
```bash
git diff [id-commit1] [id-commit2]
```

## Revenir a une version antérieure

Une fois que je dispose de plusieur commits, je peux revenir à des versions antérieure. Pour revenir à un commit précédent dans Git, vous pouvez utiliser la commande `git checkout` ou `git reset`. Le choix entre ces deux commandes dépend de ce que vous voulez accomplir. Voici un résumé des deux méthodes:

* Utiliser `git checkout` pour revenir à un commit précédent:  
Si vous voulez simple examiner le contenu d'un commit précédent sans affecter votre position actuelle, vous pouvez utiliser la commande `git checkout` suivi de l'identifiant du commit que vous voulez verifier.  
Cependant, notez que tout nouveau commit créé à partir de cet état ne sera pas sur une branche et pourrait être perdu.  
Pour revenir au commit actuel, on utilise `git switch -` (le `-` est un raccourci qui nous ramène à la précédente branche)

*Utiliser `git reset` pour revenir à un commit précédent:  
Si vous voulez revenir à un commit précédent **tout en annulant les commit ultérieurs**, vous pouvez utiliser le `git reset`.  Il existe trois modes principaux:  
`--soft`, `--mixed`(par defaut) et `--hard`.

* `--soft`: Réinitialise le HEAD au commit précédent tout en conservant les modifications en staging. Vous pouvez créer un nouveau commit avec les modifications actuelles si nécessaire.
* `--mixed`: C'est le comportement par défaut. Réinitialise le HEAD au commit précédent et annule les modifications en staging.
* `--hard`: Réinitialise complètement le HEAD et l'index au commit précédent, supprimant toutes les modifications locales.
```bash
git reset --hard id-du-commit
```
Il est important de noter que les commits ne sont pas immédiatement supprimés après un git reset, ils sont simplement déréférencés de la branche et deviennent des commits orphelins. ils sont en revanche automatiquement supprimés par Git et sa collecte automatique des déchets (garbage collector) un mois plus tard si ils ne sont pas re-référencés.

##  Création d'étiquette (tags)

La commande git tag est utilisée pour gérer les tags dans Git.  
Les tags sont des références immuables qui pointent généralement vers des commits dans l'historique d'un projet.  
Les tags sont souvent utilisés pour marquer des versions stables ou des points de repère importants dans le développement d'un projet.  
**Un tag ne peut pas contenir d'espacement**

1. **Créer un tag léger**:
```bash
git tag nom_du_tag id-commit
```
Cette commande crée un tag léger qui est simplement une référence a un commit spécifique si vous ne spécifiez pas de commit, il viendra se placer sur le commit dans lequel vous vous situez actuellement.

2. **Créer un tag complexe**
```bash
git tag -a nom_du_tag -m "description du tag" id-commit
```
Cette commande crée un tag annoté avec un message de description optionnel.

3. **Lister les tags**
```bash
git tag
```
Cette commande liste tous les tags présents dans le dépôt git.

4. **Afficher les informations d'un tag**:
```bash
git show nom_du_tag
```

5. **Supprimer un tag**:
```bash
git tag -d nom_du_tag
```

## Création de branches

Créer des branches dans Git est un concept fondamental pour la gestion du code source et la collaboration au sein d'un projet.  
Les branches permettent aux développeurs de travailler sur des fonctionnalitées, des correctifs ou des améliorations isolées sans pertuber le code principal.

* Creer une nouvelle branche: Utilisez la commande `git branch` suivie du nom de votre nouvelle branche pour la créer. `git branch nom_de_la_branche`
* Se déplacer vers la nouvelle branche: Utilisez la commande `git checkout nom_de_la_branche` pour basculer vers la nouvelle branche.
* Ou, depuis Git 2.23, vous pouvez combiner les deux étapes précédents en une seule commande (créations + déplacement):
```bash
git checkout -b nom_de_la_branche
```

* Depuis la version 2.23, il est recommandé d'utiliser la commande `git switch` pour se déplacer d'une branche à l'autre à la place de `git checkout` car le checkout est plus large est permet de se déplacer également entre commits, ce qui peut être source d'erreur. `git switch`, lui, est entièrement consacré au déplacement entre branches.
```bash
#déplacement entre branches
git switch ma_branch
#déplacement + création d'une nouvelle branche
git switch -c nouvelle_branche
```

* Si vous souhaitez renommer l'une de vos branches, il faudra utiliser la commande `git branch -m nouveau_nom`.

* Je supprime ma branche avec la commande `git branch -d nom_de_la_branche`.  
**Attention** Si ma branche comporte des données (commit), git me demandera de remplacer le -d par un -D, il s'agit d'une sécurité.

* Si je n'écris que `git branch`, j'obtiens la liste de mes branches.

* Enfin, la commande `git diff` que nous avions utilisés pour les commits fonctionne également pour comparer mes branches: 
```bash
git diff branch1 branch2
```

## Le fichier .gitignore

Un fichier .gitignore est utilisé pour specifier des règles qui servent à ignorer certains fichiers ou répertoires lors des opérations Git, comme lors du git add ou du git status par exemple. Il possède une syntaxe particulière:

**Pour ignorer un fichier ou un dossier spécifique:** Pour ignorer un fichier ou un dossier en particulier, vous ajoutez simplement son chemin relatif au répertoire racine du projet Git.
```pl
# Vous pouvez commenter un fichier .gitignore en commençant vos ligne par un dièse(#)

# Fichier à la racine
monfichier.extension
mondossier/

# Avec un chemin
mondossier/monfichier.extension
```

**Utilisez des patterns:** Vous pouvez également spécifier des plages plus grandes de dossiers et de fichiers grâce aux caracère spéciaux de patterns (combinable):
* **\* (étoile):** marche (remplace) n'importe quelle suite caractères
* **\*\*(double étoiles):** Matche n'importe quelle nombre de **dossiers**
* **! (point d'éxclamation):** Négation. Inverse une règle précédemment établie dans le .gitignore
* **? (point d'intérogation):** Matche un caractère unique
```pl
# Ignorez tous les fichiers .txt
*.txt

# Malgré que tous mes .txt soient ignorés, je veux que fichier1.txt soit surveillé
!fichier1.txt

# ignorer les fichier .txt d'un dossier
mondossier/*.txt
# Ignorer tous les fichier .txt quelque soit leur dossier

**/*.txt
# Ignorer tous les fichiers .txt faisant 4 caractères
```

Une fois votre fichier configuré, vous pouvez utilisez la commande `git add .gitignore` pour l'ajouter, puis `git commit` pour la valider.