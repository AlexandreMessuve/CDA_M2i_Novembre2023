<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_SINON" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2etat="inactif" F2lignes="" F2defaut="" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000" nbDecimales="8" maxBoucle="500000" totalAffichages="1000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="A EST_DU_TYPE NOMBRE" code="1#NOMBRE#A"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="i PREND_LA_VALEUR 0" code="5#i#0#pasliste"/>
        <item algoitem="AFFICHER &quot;Veuillez mettre un nombre compris entre 1 et 3&quot;" code="4#Veuillez mettre un nombre compris entre 1 et 3#0"/>
        <item algoitem="LIRE A" code="2#A#pasliste"/>
        <item algoitem="TANT_QUE (A &lt; 1 OU A > 3) FAIRE" code="15#A &lt; 1 OU A > 3">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="i PREND_LA_VALEUR i + 1" code="5#i#i + 1#pasliste"/>
            <item algoitem="SI (i &lt;= 3) ALORS" code="6#i &lt;= 3">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="AFFICHER &quot;Votre saisie erronée ! Veuillez recommencer &quot;" code="4#Votre saisie erronée ! Veuillez recommencer #0"/>
                <item algoitem="LIRE A" code="2#A#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="AFFICHER &quot;Votre saisie est toujours erronée, Veuillez recommencer encore : &quot;" code="4#Votre saisie est toujours erronée, Veuillez recommencer encore : #0"/>
                    <item algoitem="LIRE A" code="2#A#pasliste"/>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="SI ( i &lt;= 3) ALORS" code="6# i &lt;= 3">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="AFFICHER &quot;Bravo votre saisie est correct !&quot;" code="4#Bravo votre saisie est correct !#0"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="AFFICHER &quot;Bravo votre saisie est correct mais vous en avez mis du temps a comprendre&quot;" code="4#Bravo votre saisie est correct mais vous en avez mis du temps a comprendre#0"/>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
