<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER &quot; €&quot;" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="actif"/>
    <F2 F2etat="inactif" F2lignes="" F2defaut="" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000" nbDecimales="8" maxBoucle="500000" totalAffichages="1000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="C EST_DU_TYPE NOMBRE" code="1#NOMBRE#C"/>
        <item algoitem="T EST_DU_TYPE NOMBRE" code="1#NOMBRE#T"/>
        <item algoitem="N EST_DU_TYPE NOMBRE" code="1#NOMBRE#N"/>
        <item algoitem="Tot EST_DU_TYPE NOMBRE" code="1#NOMBRE#Tot"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Ajoutez votre capital&quot;" code="4#Ajoutez votre capital#0"/>
        <item algoitem="LIRE C" code="2#C#pasliste"/>
        <item algoitem="AFFICHER &quot;Ajoutez votre taux fixe&quot;" code="4#Ajoutez votre taux fixe#0"/>
        <item algoitem="LIRE T" code="2#T#pasliste"/>
        <item algoitem="AFFICHER &quot;Ajoutez le nombre d'année&quot;" code="4#Ajoutez le nombre d'année#0"/>
        <item algoitem="LIRE N" code="2#N#pasliste"/>
        <item algoitem="T PREND_LA_VALEUR T /100" code="5#T#T /100#pasliste"/>
        <item algoitem="T PREND_LA_VALEUR 1 + T" code="5#T#1 + T#pasliste"/>
        <item algoitem="Tot PREND_LA_VALEUR C * pow(T,N)" code="5#Tot#C * pow(T,N)#pasliste"/>
        <item algoitem="AFFICHER &quot;Votre avez gagné &quot;" code="4#Votre avez gagné #0"/>
        <item algoitem="AFFICHERCALCUL round(Tot - C)" code="20#round(Tot - C)#0"/>
        <item algoitem="AFFICHER &quot; €&quot;" code="4# €#0"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
