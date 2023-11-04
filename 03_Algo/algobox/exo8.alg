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
        <item algoitem="taille EST_DU_TYPE NOMBRE" code="1#NOMBRE#taille"/>
        <item algoitem="poids EST_DU_TYPE NOMBRE" code="1#NOMBRE#poids"/>
        <item algoitem="vTaille EST_DU_TYPE NOMBRE" code="1#NOMBRE#vTaille"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="vTaille PREND_LA_VALEUR 0" code="5#vTaille#0#pasliste"/>
        <item algoitem="AFFICHER &quot;Veuillez entree votre taille en centimètre : &quot;" code="4#Veuillez entree votre taille en centimètre : #0"/>
        <item algoitem="LIRE taille" code="2#taille#pasliste"/>
        <item algoitem="AFFICHER &quot;Veuillez entrer votre poids en kilogramme : &quot;" code="4#Veuillez entrer votre poids en kilogramme : #0"/>
        <item algoitem="LIRE poids" code="2#poids#pasliste"/>
        <item algoitem="SI (taille >= 145 ET taille &lt;= 183 ET poids >= 43 ET poids &lt;= 77) ALORS" code="6#taille >= 145 ET taille &lt;= 183 ET poids >= 43 ET poids &lt;= 77">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="SI (taille >= 145 ET taille &lt; 172 ET poids >= 43 ET poids &lt;= 65) ALORS" code="6#taille >= 145 ET taille &lt; 172 ET poids >= 43 ET poids &lt;= 65">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="SI (poids >= 43 ET poids &lt;= 47 ET taille &lt; 172 OU poids >= 48 ET poids &lt;= 53 ET taille &lt; 169 OU poids >= 54 ET poids &lt;= 59 ET taille &lt; 166 OU poids >= 60 ET poids &lt;= 65 ET taille &lt; 163 ) ALORS" code="6#poids >= 43 ET poids &lt;= 47 ET taille &lt; 172 OU poids >= 48 ET poids &lt;= 53 ET taille &lt; 169 OU poids >= 54 ET poids &lt;= 59 ET taille &lt; 166 OU poids >= 60 ET poids &lt;= 65 ET taille &lt; 163 ">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="vTaille PREND_LA_VALEUR 1" code="5#vTaille#1#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (taille >= 160 ET taille &lt; 183 ET poids >= 48 ET poids &lt;= 71) ALORS" code="6#taille >= 160 ET taille &lt; 183 ET poids >= 48 ET poids &lt;= 71">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="SI (poids >= 48 ET poids &lt;= 53 ET taille >= 169 ET taille &lt; 183 OU poids >= 54 ET poids &lt;= 59 ET taille >= 166 ET taille &lt; 178 OU poids >= 60 ET poids &lt;= 65 ET taille >= 163 ET taille &lt; 175 OU poids >= 66 ET poids &lt;= 71 ET taille >= 160  ET taille &lt; 172) ALORS" code="6#poids >= 48 ET poids &lt;= 53 ET taille >= 169 ET taille &lt; 183 OU poids >= 54 ET poids &lt;= 59 ET taille >= 166 ET taille &lt; 178 OU poids >= 60 ET poids &lt;= 65 ET taille >= 163 ET taille &lt; 175 OU poids >= 66 ET poids &lt;= 71 ET taille >= 160  ET taille &lt; 172">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="vTaille PREND_LA_VALEUR 2" code="5#vTaille#2#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (taille >= 163 ET taille &lt;= 183 ET poids >= 54 ET poids &lt;= 77) ALORS" code="6#taille >= 163 ET taille &lt;= 183 ET poids >= 54 ET poids &lt;= 77">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="SI (poids >= 54 ET poids &lt;= 59 ET taille >= 178 OU poids >= 60 ET poids &lt;= 65 ET taille >= 175 OU poids >= 66 ET poids &lt;= 71 ET taille >= 172 OU poids >= 72 ET poids &lt;= 77 ET taille >= 163 ) ALORS" code="6#poids >= 54 ET poids &lt;= 59 ET taille >= 178 OU poids >= 60 ET poids &lt;= 65 ET taille >= 175 OU poids >= 66 ET poids &lt;= 71 ET taille >= 172 OU poids >= 72 ET poids &lt;= 77 ET taille >= 163 ">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="vTaille PREND_LA_VALEUR 3" code="5#vTaille#3#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="SI (vTaille != 0) ALORS" code="6#vTaille != 0">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="AFFICHER &quot;Votre taille de vêtement est : &quot;" code="4#Votre taille de vêtement est : #0"/>
                <item algoitem="AFFICHER vTaille" code="3#vTaille#0#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="AFFICHER &quot;Nous avons pas votre taille&quot;" code="4#Nous avons pas votre taille#0"/>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="AFFICHER &quot;Nous n'avons pas trouvé votre taille&quot;" code="4#Nous n'avons pas trouvé votre taille#0"/>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
