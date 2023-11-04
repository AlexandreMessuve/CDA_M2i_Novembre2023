<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER Total" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2etat="inactif" F2lignes="" F2defaut="" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000" nbDecimales="8" maxBoucle="500000" totalAffichages="1000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="C EST_DU_TYPE NOMBRE" code="1#NOMBRE#C"/>
        <item algoitem="T EST_DU_TYPE NOMBRE" code="1#NOMBRE#T"/>
        <item algoitem="A EST_DU_TYPE NOMBRE" code="1#NOMBRE#A"/>
        <item algoitem="Total EST_DU_TYPE NOMBRE" code="1#NOMBRE#Total"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="A PREND_LA_VALEUR 0" code="5#A#0#pasliste"/>
        <item algoitem="AFFICHER &quot;Veuillez entrer votre capital&quot;" code="4#Veuillez entrer votre capital#0"/>
        <item algoitem="LIRE C" code="2#C#pasliste"/>
        <item algoitem="AFFICHER &quot;Veuillez entrer votre taux fixe&quot;" code="4#Veuillez entrer votre taux fixe#0"/>
        <item algoitem="LIRE T" code="2#T#pasliste"/>
        <item algoitem="T PREND_LA_VALEUR T/100" code="5#T#T/100#pasliste"/>
        <item algoitem="T PREND_LA_VALEUR 1 + T" code="5#T#1 + T#pasliste"/>
        <item algoitem="TANT_QUE (Total &lt; C * 2) FAIRE" code="15#Total &lt; C * 2">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="A PREND_LA_VALEUR A + 1" code="5#A#A + 1#pasliste"/>
            <item algoitem="Total PREND_LA_VALEUR C * pow(T,A)" code="5#Total#C * pow(T,A)#pasliste"/>
            <item algoitem="Total PREND_LA_VALEUR round(Total)" code="5#Total#round(Total)#pasliste"/>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="AFFICHER &quot;Il vous faudra &quot;" code="4#Il vous faudra #0"/>
        <item algoitem="AFFICHER A" code="3#A#0#pasliste"/>
        <item algoitem="AFFICHER &quot; années pour doubler votre capital avec un total de &quot;" code="4# années pour doubler votre capital avec un total de #0"/>
        <item algoitem="AFFICHER Total" code="3#Total#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
