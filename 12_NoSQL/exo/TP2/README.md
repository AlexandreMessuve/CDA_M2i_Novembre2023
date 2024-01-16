# TP 2

## 01 Create

Importation des données :

![Image de l'importation](./img/importation_user.png)

Insertion de Chuck Norris dans la bdd:

![Image de l'insertion de chuck norris](./img/ajout_chucknorris.png)

## 02 Read

Affichage de Chuck Norris:

![Image de l'importation](./img/affichage_chucknorris.png)

Affichage de Chuck Norris sans id: 
```bash
db.users.find({name: "Chuck Norris"}, {_id: false})
```

Affichage utilisateur entre 20 et 25 ans:

![Image de l'importation](./img/affichage_age_20-25.png)

Affichage homme entre 30 et 40 ans: 

![Image de l'importation](./img/affichagehomme_age_30-40.png)

Affichage utilisateur habitant en Louisiane: 

![Image de l'importation](./img/habitant_louisiane.png)

Affichage les 20 premiers utilisateur en ordre décroissant d'age:

![Image de l'importation](./img/affichage_age_decroissant.png)

Affichage du nombre de femme dont l'age est de 30: 

![Image de l'importation](./img/affichage_nombre_femme_age_30.png)

## 03 Update

Update l'age de Chuck Norris pour mettre Infinity:

![Image de l'importation](./img/update_age_chucknorris.png)

Update les utilisateur en enlevant le champs Phone:

![Image de l'importation](./img/update_users_delete_phone.png)

Update les utilisateur de plus de 50 ans en ajoutant jardinage dans leur hobbies:

```bash
db.users.updateMany({age: {$gt:50}}, {$push: {hobbies: "jardinage"}})
```