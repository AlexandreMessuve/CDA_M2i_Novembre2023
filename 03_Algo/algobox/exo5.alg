<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot; €&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2lignes="" F2defaut="" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param nbDecimales="8" epaisseurPoint="2" arrondiAuto="vrai" totalAffichages="1000" totalBoucles="5000000" epaisseurLigne="2" maxBoucle="500000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="A EST_DU_TYPE NOMBRE" code="1#NOMBRE#A"/>
        <item algoitem="RES EST_DU_TYPE NOMBRE" code="1#NOMBRE#RES"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Mettez le nombre de copies que vous voulez :&quot;" code="4#Mettez le nombre de copies que vous voulez :#0"/>
        <item algoitem="LIRE A" code="2#A#pasliste"/>
        <item algoitem="SI (A &lt; 10) ALORS" code="6#A &lt; 10">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="RES PREND_LA_VALEUR A * 0.50" code="5#RES#A * 0.50#pasliste"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="SI (A >= 10 ET A &lt; 20) ALORS" code="6#A >= 10 ET A &lt; 20">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="RES PREND_LA_VALEUR A * 0.40" code="5#RES#A * 0.40#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                    <item algoitem="SINON" code="9#sinon">
                        <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                        <item algoitem="RES PREND_LA_VALEUR A * 0.30" code="5#RES#A * 0.30#pasliste"/>
                        <item algoitem="FIN_SINON" code="11#finsinon"/>
                    </item>
                </item>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
        <item algoitem="AFFICHER &quot;Vous avez commamndé &quot;" code="4#Vous avez commamndé #0"/>
        <item algoitem="AFFICHER A" code="3#A#0#pasliste"/>
        <item algoitem="AFFICHER &quot; copies vous devrez payer : &quot;" code="4# copies vous devrez payer : #0"/>
        <item algoitem="AFFICHER RES" code="3#RES#0#pasliste"/>
        <item algoitem="AFFICHER &quot; €&quot;" code="4# €#0"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
