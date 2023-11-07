<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER nbMax"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2etat="inactif" F2para="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalAffichages="1000" arrondiAuto="vrai" nbDecimales="8" maxBoucle="500000" totalBoucles="5000000" epaisseurLigne="2" epaisseurPoint="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions">
        <item algoitem="FONCTION nombrePlusGrand (nombre1, nombre2)" code="201#nombrePlusGrand #nombre1, nombre2">
            <item algoitem="VARIABLES_FONCTION" code="202#declarationsvariablesfonction">
                <item algoitem="e EST_DU_TYPE NOMBRE" code="1#NOMBRE#e"/>
            </item>
            <item algoitem="DEBUT_FONCTION" code="203#debutfonction"/>
            <item algoitem="SI (nombre1 > nombre2) ALORS" code="6#nombre1 > nombre2">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="e PREND_LA_VALEUR nombre1" code="5#e#nombre1#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="e PREND_LA_VALEUR nombre2" code="5#e#nombre2#pasliste"/>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="RENVOYER e" code="205#e"/>
            <item algoitem="FIN_FONCTION" code="204#finfonction"/>
        </item>
    </item>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="nombre1 EST_DU_TYPE NOMBRE" code="1#NOMBRE#nombre1"/>
        <item algoitem="nombre2 EST_DU_TYPE NOMBRE" code="1#NOMBRE#nombre2"/>
        <item algoitem="nbMax EST_DU_TYPE NOMBRE" code="1#NOMBRE#nbMax"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Veuillez entrer le premier nombre: &quot;" code="4#Veuillez entrer le premier nombre: #0"/>
        <item algoitem="LIRE nombre1" code="2#nombre1#pasliste"/>
        <item algoitem="AFFICHER &quot;Veuillez entrer le deuxieme nombre: &quot;" code="4#Veuillez entrer le deuxieme nombre: #0"/>
        <item algoitem="LIRE nombre2" code="2#nombre2#pasliste"/>
        <item algoitem="nbMax PREND_LA_VALEUR nombrePlusGrand (nombre1, nombre2)" code="5#nbMax#nombrePlusGrand (nombre1, nombre2)#pasliste"/>
        <item algoitem="AFFICHER &quot;Le plus grands nombre est : &quot;" code="4#Le plus grands nombre est : #0"/>
        <item algoitem="AFFICHER nbMax" code="3#nbMax#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
