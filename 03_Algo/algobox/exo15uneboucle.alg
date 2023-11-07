<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_POUR" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2lignes="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param maxBoucle="500000" epaisseurLigne="2" epaisseurPoint="2" arrondiAuto="vrai" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#j" algoitem="j EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#j#1#pasliste" algoitem="j PREND_LA_VALEUR 1"/>
        <item code="12#i#1#10" algoitem="POUR i ALLANT_DE 1 A 10">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="6#j &lt;= 10" algoitem="SI (j &lt;= 10) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="6#i == 1" algoitem="SI (i == 1) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#Table de #0" algoitem="AFFICHER &quot;Table de &quot;"/>
                    <item code="3#j#1#pasliste" algoitem="AFFICHER j"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="6#i &lt; 10" algoitem="SI (i &lt; 10) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="3#j#0#pasliste" algoitem="AFFICHER j"/>
                    <item code="4# x #0" algoitem="AFFICHER &quot; x &quot;"/>
                    <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                    <item code="4# = #0" algoitem="AFFICHER &quot; = &quot;"/>
                    <item code="20#j * i#1" algoitem="AFFICHERCALCUL j * i"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                    <item code="9#sinon" algoitem="SINON">
                        <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                        <item code="3#j#0#pasliste" algoitem="AFFICHER j"/>
                        <item code="4# x #0" algoitem="AFFICHER &quot; x &quot;"/>
                        <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                        <item code="4# = #0" algoitem="AFFICHER &quot; = &quot;"/>
                        <item code="20#j * i#1" algoitem="AFFICHERCALCUL j * i"/>
                        <item code="5#j#j + 1#pasliste" algoitem="j PREND_LA_VALEUR j + 1"/>
                        <item code="5#i#0#pasliste" algoitem="i PREND_LA_VALEUR 0"/>
                        <item code="11#finsinon" algoitem="FIN_SINON"/>
                    </item>
                </item>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
