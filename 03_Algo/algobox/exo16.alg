<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER moy" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2lignes="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param maxBoucle="500000" epaisseurLigne="2" epaisseurPoint="2" arrondiAuto="vrai" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#noteMax" algoitem="noteMax EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#noteMin" algoitem="noteMin EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#note" algoitem="note EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nbNote" algoitem="nbNote EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#moy" algoitem="moy EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Combien de notes voulez vous mettre ? #0" algoitem="AFFICHER &quot;Combien de notes voulez vous mettre ? &quot;"/>
        <item code="2#nbNote#pasliste" algoitem="LIRE nbNote"/>
        <item code="5#moy#0#pasliste" algoitem="moy PREND_LA_VALEUR 0"/>
        <item code="12#i#1#nbNote" algoitem="POUR i ALLANT_DE 1 A nbNote">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Note n°#0" algoitem="AFFICHER &quot;Note n°&quot;"/>
            <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
            <item code="2#note#pasliste" algoitem="LIRE note"/>
            <item code="6#i == 1" algoitem="SI (i == 1) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#noteMax#note#pasliste" algoitem="noteMax PREND_LA_VALEUR note"/>
                <item code="5#noteMin#note#pasliste" algoitem="noteMin PREND_LA_VALEUR note"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#note &lt; noteMin" algoitem="SI (note &lt; noteMin) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#noteMin#note#pasliste" algoitem="noteMin PREND_LA_VALEUR note"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#noteMax &lt; note" algoitem="SI (noteMax &lt; note) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#noteMax#note#pasliste" algoitem="noteMax PREND_LA_VALEUR note"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="5#moy#moy + note#pasliste" algoitem="moy PREND_LA_VALEUR moy + note"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="5#moy#moy / nbNote#pasliste" algoitem="moy PREND_LA_VALEUR moy / nbNote"/>
        <item code="4#La plus petite note est : #0" algoitem="AFFICHER &quot;La plus petite note est : &quot;"/>
        <item code="3#noteMin#1#pasliste" algoitem="AFFICHER noteMin"/>
        <item code="4#La plus grande note est : #0" algoitem="AFFICHER &quot;La plus grande note est : &quot;"/>
        <item code="3#noteMax#1#pasliste" algoitem="AFFICHER noteMax"/>
        <item code="4#La moyenne est de #0" algoitem="AFFICHER &quot;La moyenne est de &quot;"/>
        <item code="3#moy#1#pasliste" algoitem="AFFICHER moy"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
