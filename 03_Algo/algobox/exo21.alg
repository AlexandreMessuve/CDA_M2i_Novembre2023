<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="FIN_POUR"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2defaut="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalAffichages="1000" arrondiAuto="vrai" epaisseurPoint="2" maxBoucle="500000" nbDecimales="8" totalBoucles="5000000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="note EST_DU_TYPE LISTE" code="1#LISTE#note"/>
        <item algoitem="matiere EST_DU_TYPE LISTE" code="1#LISTE#matiere"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="j EST_DU_TYPE NOMBRE" code="1#NOMBRE#j"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="POUR i ALLANT_DE 0 A 3 - 1" code="12#i#0#3 - 1">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="AFFICHER &quot;Matière &quot;" code="4#Matière #0"/>
            <item algoitem="AFFICHERCALCUL i+1" code="20#i+1#1"/>
            <item algoitem="POUR j ALLANT_DE 0 A 15 - 1" code="12#j#0#15 - 1">
                <item algoitem="DEBUT_POUR" code="13#debutpour"/>
                <item algoitem="AFFICHER &quot;Note n°&quot;" code="4#Note n°#0"/>
                <item algoitem="AFFICHERCALCUL j+1" code="20#j+1#0"/>
                <item algoitem="LIRE note[i * 15 + j]" code="2#note#i * 15 + j"/>
                <item algoitem="FIN_POUR" code="14#finpour"/>
            </item>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="POUR i ALLANT_DE 0 A 3 - 1" code="12#i#0#3 - 1">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="AFFICHER &quot;_________&quot;" code="4#_________#1"/>
            <item algoitem="AFFICHER &quot;Matière &quot;" code="4#Matière #0"/>
            <item algoitem="AFFICHERCALCUL i+1" code="20#i+1#0"/>
            <item algoitem="AFFICHER &quot; | &quot;" code="4# | #0"/>
            <item algoitem="POUR j ALLANT_DE 0 A 15 - 1" code="12#j#0#15 - 1">
                <item algoitem="DEBUT_POUR" code="13#debutpour"/>
                <item algoitem="AFFICHER note[i  * 15+ j]" code="3#note#0#i  * 15+ j"/>
                <item algoitem="AFFICHER &quot; | &quot;" code="4# | #0"/>
                <item algoitem="FIN_POUR" code="14#finpour"/>
            </item>
            <item algoitem="AFFICHER &quot; &quot;" code="4# #1"/>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
