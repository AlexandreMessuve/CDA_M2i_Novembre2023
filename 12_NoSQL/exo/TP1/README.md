# TP 01

Insertion des 3 patient :

```bash
db.patient.insertMany([
    {
        firstname: "Mohammed",
        lastname: "Deloin",
        age: 30,
        history: [
            {desease: "rhume", treatment: "sirop"},
            {desease: "grippe", treatment: "anti biotique"}
        ]
    },
    {
        firstname: "Alexandre",
        lastname: "Messuve",
        age: 26,
        history: [
            {desease: "grippe", treatment: "anti biotique"}
        ]
    },
    {
        firstname: "George",
        lastname: "Abidbol",
        age: 80,
        history: [
            {desease: "covid-40", treatment: "décés"}
        ]
    }
])
```

Mise à jour d'un patient avec un nouvel age, nouveau nom et un nouvel historique medical:

```bash
db.patient.updateOne({lastname: "Messuve"}, {$set: {age: 25, lastname: "Penet", history: [{desease: "covid-19", treatment: "doliprane"}]}})
```

Trouver tous les patient qui ont un age supérieur à 29:
```bash
db.patient.find({age: {$gt:29}})
```

Supprimer tous les patients qui ont attrapé un rhume comme maladie:

```bash
db.patient.deleteMany({"history.desease": "rhume"})
```