<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_SINON" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2defaut="" F2para="" F2lignes="" F2etat="inactif"/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" nbDecimales="8" totalAffichages="1000" maxBoucle="500000" arrondiAuto="vrai" epaisseurLigne="2" totalBoucles="5000000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="A EST_DU_TYPE NOMBRE" code="1#NOMBRE#A"/>
        <item algoitem="M EST_DU_TYPE CHAINE" code="1#CHAINE#M"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Veuillez entrer l'age de votre enfant ? &quot;" code="4#Veuillez entrer l'age de votre enfant ? #0"/>
        <item algoitem="LIRE A" code="2#A#pasliste"/>
        <item algoitem="SI (A >= 3) ALORS" code="6#A >= 3">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="SI (A >= 3 ET A &lt;= 6) ALORS" code="6#A >= 3 ET A &lt;= 6">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="M PREND_LA_VALEUR &quot;Baby&quot;" code="5#M#&quot;Baby&quot;#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (A >= 7 ET A &lt;= 8) ALORS" code="6#A >= 7 ET A &lt;= 8">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="M PREND_LA_VALEUR &quot;Poussin&quot;" code="5#M#&quot;Poussin&quot;#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (A >= 9 ET A &lt;= 10) ALORS" code="6#A >= 9 ET A &lt;= 10">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="M PREND_LA_VALEUR &quot;Pupille&quot;" code="5#M#&quot;Pupille&quot;#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (A >= 11 ET A &lt;= 12) ALORS" code="6#A >= 11 ET A &lt;= 12">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="M PREND_LA_VALEUR &quot;Minime&quot;" code="5#M#&quot;Minime&quot;#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (A >= 13) ALORS" code="6#A >= 13">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="M PREND_LA_VALEUR &quot;Cadet&quot;" code="5#M#&quot;Cadet&quot;#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="AFFICHER &quot;La catégorie sportive de votre enfant est : &quot;" code="4#La catégorie sportive de votre enfant est : #0"/>
            <item algoitem="AFFICHER M" code="3#M#0#pasliste"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="AFFICHER &quot;Votre enfant est trop jeune &quot;" code="4#Votre enfant est trop jeune #0"/>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
