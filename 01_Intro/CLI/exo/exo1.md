```powershell
# Créez un nouveau dossier appelé "Exercice_CLI"
mkdir Exercice_CLI
# Accédez au dossier que vous venez de créer
cd Exercice_CLI
# Créez trois fichiers à l'intérieur du dossier "Exercice_CLI" : "fichier1.txt", "fichier2.txt" et "fichier3.txt".
echo . > ficher1.txt
echo . > ficher2.txt
echo . > ficher3.txt 
# Listez les fichiers du dossier.
ls
# Copiez "fichier1.txt" dans un sous-dossier appelé "SousDossier" à l'intérieur de "Exercice_CLI".
mkdir SousDossier
cp fichier1.txt SousDossier
# Renommez "fichier2.txt" en "nouveau_fichier.txt".
mv fichier2.txt nouveau_fichier.txt
# Déplacez "nouveau_fichier.txt" dans le dossier "SousDossier".
mv nouveau_fichier.txt SousDossier
# Supprimez le dossier "SousDossier" et son contenu.
rm -r SousDossier
# Revenez au dossier parent.
cd ../
# Supprimez le dossier "Exercice_CLI" et son contenu.
rm -r Exercice_CLI 
```