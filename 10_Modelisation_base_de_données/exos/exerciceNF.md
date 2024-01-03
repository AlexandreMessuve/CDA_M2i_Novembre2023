# énoncé

**Contexte :** Vous travaillez sur une base de données pour une entreprise d'organisation d'événements. La base de
données actuelle, sous format CSV, contient des informations détaillées sur les événements organisés, y compris les
détails des participants, les types d'événements, les lieux, et les dates. Les données actuelles ne sont pas
structurées de manière optimale et présentent des redondances.

**Tâche :** Votre objectif est de restructurer cette base de données pour atteindre la Troisième Forme Normale (3NF).
Vous devez éliminer les redondances et organiser les données de manière logique et efficace.

**Étapes :**
1. Analyser le fichier CSV fourni pour identifier les anomalies de normalisation.
2. Concevoir un plan de normalisation pour structurer correctement la base de données.
3. Proposer de nouvelles structures de tables qui respectent les normes de normalisation.

## Le CSV

```csv
EvenementID, TypeEvenement, Date, Lieu, ParticipantID, NomParticipant, EmailParticipant
E01, Conférence, 2021-09-15, Centre des Congrès, P01, Jean Dupont, jean.dupont@email.com
E02, Séminaire, 2021-09-20, Hôtel de Ville, P02, Marie Curie, marie.curie@email.com
E02, Séminaire, 2021-09-20, Hôtel de Ville, P03, Albert Einstein, albert.einstein@email.com
E01, Conférence, 2021-09-15, Centre des Congrès, P04, Isaac Newton, isaac.newton@email.com
```


# Ma solution

On peux séparer les événement et les participant :

### Evenement

|EvenementID|TypeEvenement|Date|Lieu|
|:-:|:-:|:-:|:-:|
|E01|Conférence|2021-09-15|Centre des Congrès|
|E02|Séminaire|2021-09-20|Hôtel de Ville|


### Participant


|ParticipantID|NomParticipant|EmailParticipant|
|:-:|:-:|:-:|
|P01|Jean Dupont| jean.dupont@email.com|
|P02|Marie Curie|marie.curie@email.com|
|P03|Albert Einstein|albert.einstein@email.com|
|P04|Isaac Newton|isaac.newton@email.com|


Pour les lier on créera un nouveau tableau nommée evenement_participant

### Evenement_participant


|evenement_id | participant_id |
|:-:|:-:|
|E01|P01|
|E01|P04|
|E02|P02|
|E02|P03|

