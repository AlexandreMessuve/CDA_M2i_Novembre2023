<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER &quot; habitants dans la ville de tourcoing&quot;" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2lignes="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param maxBoucle="500000" epaisseurLigne="2" epaisseurPoint="2" arrondiAuto="vrai" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#ans" algoitem="ans EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#hab" algoitem="hab EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#taux" algoitem="taux EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#ans#0#pasliste" algoitem="ans PREND_LA_VALEUR 0"/>
        <item code="5#hab#96809#pasliste" algoitem="hab PREND_LA_VALEUR 96809"/>
        <item code="5#taux#1 + 0.0089#pasliste" algoitem="taux PREND_LA_VALEUR 1 + 0.0089"/>
        <item code="15#hab &lt; 120000" algoitem="TANT_QUE (hab &lt; 120000) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="5#ans#ans + 1#pasliste" algoitem="ans PREND_LA_VALEUR ans + 1"/>
            <item code="5#hab#hab * taux#pasliste" algoitem="hab PREND_LA_VALEUR hab * taux"/>
            <item code="5#hab#round(hab)#pasliste" algoitem="hab PREND_LA_VALEUR round(hab)"/>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="4#Il faut #0" algoitem="AFFICHER &quot;Il faut &quot;"/>
        <item code="3#ans#0#pasliste" algoitem="AFFICHER ans"/>
        <item code="4# années pour atteindre #0" algoitem="AFFICHER &quot; années pour atteindre &quot;"/>
        <item code="3#hab#0#pasliste" algoitem="AFFICHER hab"/>
        <item code="4# habitants dans la ville de tourcoing#0" algoitem="AFFICHER &quot; habitants dans la ville de tourcoing&quot;"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
