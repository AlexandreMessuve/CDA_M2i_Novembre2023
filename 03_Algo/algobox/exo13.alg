<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER nMax"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2defaut="" F2etat="inactif" F2para="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" nbDecimales="8" totalAffichages="1000" maxBoucle="500000" epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="n EST_DU_TYPE NOMBRE" code="1#NOMBRE#n"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="nMax EST_DU_TYPE NOMBRE" code="1#NOMBRE#nMax"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="nMax PREND_LA_VALEUR 0" code="5#nMax#0#pasliste"/>
        <item algoitem="POUR i ALLANT_DE 1 A 6" code="12#i#1#6">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="AFFICHER &quot;Veuillez entrer un nombre n°&quot;" code="4#Veuillez entrer un nombre n°#0"/>
            <item algoitem="AFFICHER i" code="3#i#0#pasliste"/>
            <item algoitem="AFFICHER &quot; : &quot;" code="4# : #0"/>
            <item algoitem="LIRE n" code="2#n#pasliste"/>
            <item algoitem="SI (nMAx &lt; n) ALORS" code="6#nMAx &lt; n">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="nMax PREND_LA_VALEUR n" code="5#nMax#n#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="AFFICHER &quot;Le nombre le plus grand est : &quot;" code="4#Le nombre le plus grand est : #0"/>
        <item algoitem="AFFICHER nMax" code="3#nMax#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
