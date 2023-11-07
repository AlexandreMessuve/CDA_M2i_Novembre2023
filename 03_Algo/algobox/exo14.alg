<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_POUR" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2etat="inactif" F2lignes="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" nbDecimales="8" epaisseurPoint="2" arrondiAuto="vrai" totalAffichages="1000" totalBoucles="5000000" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#nb" algoitem="nb EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#calcul" algoitem="calcul EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#calcul#0#pasliste" algoitem="calcul PREND_LA_VALEUR 0"/>
        <item code="4#Veuillez saisir un nombre#0" algoitem="AFFICHER &quot;Veuillez saisir un nombre&quot;"/>
        <item code="2#nb#pasliste" algoitem="LIRE nb"/>
        <item code="12#i#1#nb" algoitem="POUR i ALLANT_DE 1 A nb">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="5#calcul#calcul + i#pasliste" algoitem="calcul PREND_LA_VALEUR calcul + i"/>
            <item code="6#i != nb" algoitem="SI (i != nb) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                <item code="4# + #0" algoitem="AFFICHER &quot; + &quot;"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="3#nb#0#pasliste" algoitem="AFFICHER nb"/>
                    <item code="4# = #0" algoitem="AFFICHER &quot; = &quot;"/>
                    <item code="3#calcul#0#pasliste" algoitem="AFFICHER calcul"/>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
