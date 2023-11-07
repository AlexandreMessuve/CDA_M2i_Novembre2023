<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="FIN_TANT_QUE"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2lignes="" F2etat="inactif" F2defaut="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalBoucles="5000000" arrondiAuto="vrai" epaisseurPoint="2" maxBoucle="500000" epaisseurLigne="2" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#menu1# " algoitem="FONCTION menu1( )">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
            <item code="4#Pour afficher la plus petite note tapez 1#1" algoitem="AFFICHER &quot;Pour afficher la plus petite note tapez 1&quot;"/>
            <item code="4#Pour afficher la plus grande note tapez 2#1" algoitem="AFFICHER &quot;Pour afficher la plus grande note tapez 2&quot;"/>
            <item code="4#Pour afficher la moyenne tapez 3#1" algoitem="AFFICHER &quot;Pour afficher la moyenne tapez 3&quot;"/>
            <item code="4#Pour partir tapez 0#1" algoitem="AFFICHER &quot;Pour partir tapez 0&quot;"/>
            <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
        <item code="201#menu2# " algoitem="FONCTION menu2( )">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
            <item code="4#Tapez 1 pour retourner au menu principal#1" algoitem="AFFICHER &quot;Tapez 1 pour retourner au menu principal&quot;"/>
            <item code="4#Tapez 0 pour sortir du programme#1" algoitem="AFFICHER &quot;Tapez 0 pour sortir du programme&quot;"/>
            <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#noteMax" algoitem="noteMax EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#noteMin" algoitem="noteMin EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#note" algoitem="note EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nbNote" algoitem="nbNote EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#moy" algoitem="moy EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#flag" algoitem="flag EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#menu" algoitem="menu EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Combien de notes voulez vous mettre ? #0" algoitem="AFFICHER &quot;Combien de notes voulez vous mettre ? &quot;"/>
        <item code="2#nbNote#pasliste" algoitem="LIRE nbNote"/>
        <item code="5#flag#0#pasliste" algoitem="flag PREND_LA_VALEUR 0"/>
        <item code="5#moy#0#pasliste" algoitem="moy PREND_LA_VALEUR 0"/>
        <item code="12#i#1#nbNote" algoitem="POUR i ALLANT_DE 1 A nbNote">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
            <item code="4#Note n°#0" algoitem="AFFICHER &quot;Note n°&quot;"/>
            <item code="3#i#1#pasliste" algoitem="AFFICHER i"/>
            <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
            <item code="2#note#pasliste" algoitem="LIRE note"/>
            <item code="15#note &lt; 0 OU note > 20" algoitem="TANT_QUE (note &lt; 0 OU note > 20) FAIRE">
                <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="4#Veuillez mettre une note compris entre 0 et 20#1" algoitem="AFFICHER &quot;Veuillez mettre une note compris entre 0 et 20&quot;"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="2#note#pasliste" algoitem="LIRE note"/>
                <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
            </item>
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
        <item code="15#flag == 0" algoitem="TANT_QUE (flag == 0) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="206#menu1()" algoitem="APPELER_FONCTION menu1()"/>
            <item code="2#menu#pasliste" algoitem="LIRE menu"/>
            <item code="6#menu &lt; 0 OU menu > 3" algoitem="SI (menu &lt; 0 OU menu > 3) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="4#Veuillez entrer le numéro lier a la catégorie que vous voulez#1" algoitem="AFFICHER &quot;Veuillez entrer le numéro lier a la catégorie que vous voulez&quot;"/>
                <item code="206#menu1()" algoitem="APPELER_FONCTION menu1()"/>
                <item code="2#menu#pasliste" algoitem="LIRE menu"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#menu == 1" algoitem="SI (menu == 1) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="4#La plus petite note est : #0" algoitem="AFFICHER &quot;La plus petite note est : &quot;"/>
                <item code="3#noteMin#1#pasliste" algoitem="AFFICHER noteMin"/>
                <item code="206#menu2()" algoitem="APPELER_FONCTION menu2()"/>
                <item code="2#menu#pasliste" algoitem="LIRE menu"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#menu == 2" algoitem="SI (menu == 2) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="4#La plus grande note est : #0" algoitem="AFFICHER &quot;La plus grande note est : &quot;"/>
                <item code="3#noteMax#1#pasliste" algoitem="AFFICHER noteMax"/>
                <item code="206#menu2()" algoitem="APPELER_FONCTION menu2()"/>
                <item code="2#menu#pasliste" algoitem="LIRE menu"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#menu == 3" algoitem="SI (menu == 3) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="4#La moyenne est de : #0" algoitem="AFFICHER &quot;La moyenne est de : &quot;"/>
                <item code="3#moy#1#pasliste" algoitem="AFFICHER moy"/>
                <item code="206#menu2()" algoitem="APPELER_FONCTION menu2()"/>
                <item code="2#menu#pasliste" algoitem="LIRE menu"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#menu == 0" algoitem="SI (menu == 0) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="4#Aurevoir#1" algoitem="AFFICHER &quot;Aurevoir&quot;"/>
                <item code="4#---------------#1" algoitem="AFFICHER &quot;---------------&quot;"/>
                <item code="5#flag#1#pasliste" algoitem="flag PREND_LA_VALEUR 1"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
