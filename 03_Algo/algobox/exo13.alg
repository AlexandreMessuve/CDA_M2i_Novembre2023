<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER nMax" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2etat="inactif" F2lignes="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" nbDecimales="8" epaisseurPoint="2" arrondiAuto="vrai" totalAffichages="1000" totalBoucles="5000000" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nMax" algoitem="nMax EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="12#i#1#6" algoitem="POUR i ALLANT_DE 1 A 6">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Veuillez entrer un nombre n°#0" algoitem="AFFICHER &quot;Veuillez entrer un nombre n°&quot;"/>
            <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
            <item code="4# : #0" algoitem="AFFICHER &quot; : &quot;"/>
            <item code="2#n#pasliste" algoitem="LIRE n"/>
            <item code="6#nMax &lt; n OU i == 1" algoitem="SI (nMax &lt; n OU i == 1) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#nMax#n#pasliste" algoitem="nMax PREND_LA_VALEUR n"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="4#Le nombre le plus grand est : #0" algoitem="AFFICHER &quot;Le nombre le plus grand est : &quot;"/>
        <item code="3#nMax#0#pasliste" algoitem="AFFICHER nMax"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
