package org.stream.exercices;

import org.scientifique.Person;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 400),
                new Transaction(brian, 2012, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 410),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
        //Question 01
        /*Trouvez toutes les transactions en 2011 et les trier par valeur
          (petite à élevée) stocker ces données dans une liste de transactions.*/


        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("--------------------");
        //Question 02
        /*Quelles sont toutes les villes uniques où les traders travaillent :
          stocker ses données dans une liste de villes (chaîne de caractères).
          2 possibilités (dont une en utilisant les Set).*/

        // 1ère possibilité
        HashSet<String> citiesSet = new HashSet<>();
        transactions.stream()
                .forEach((t) -> citiesSet.add(t.getTrader().getCity()));
        System.out.println("The cities set: ");
        citiesSet.stream().forEach(System.out::println);
        System.out.println("--------------------");
        //2ème possibilité
        List<String> citiesList = transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println("The cities list: ");
        citiesList.stream()
                .forEach(System.out::println);

        System.out.println("--------------------");
        //Question 03
        /*En vous basant, toujours uniquement sur les transactions, renvoyez
        une chaîne de noms de tous les traders triés par ordre
        alphabétique*/
        System.out.println("Liste des traders par ordre alphabétique");
        String traders = transactions.stream()
                .map(t->t.getTrader().getName())
                .sorted()
                .distinct()
                .collect(Collectors.joining("\n"));
        System.out.println(traders);
        System.out.println("--------------------");

        //Question 04
        /*Y a-t-il des commerçants basés à Milan ? On récupère un booléen
        dans les résultats.*/
        Optional<Trader> trader = transactions.stream()
                .map((Transaction::getTrader))
                .filter(tTrader -> tTrader.getCity().equalsIgnoreCase("milan"))
                .findFirst();
        if(trader.isPresent()) {
            System.out.println("Oui il y a des commerçants basés à Milan");
        }else{
            System.out.println("Non il ni a pas de commerçants basés à Milan");
        }
        System.out.println("--------------------");
        System.out.println("La valeur la plus élevée");
        //Question 05
        /*Quelle est la valeur la plus élevée de toutes les transactions ? (On
        récupère un optional d’entier).*/
        Optional<Integer> valueMax = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);

        valueMax.stream().forEach(System.out::println);

        System.out.println("--------------------");

        //Question 06
        /*Trouvez tous les traders de Cambridge et les triez par nom. On
        récupère une liste de traders.*/
        System.out.println("Liste des traders de cambridge trier par nom");
        List<Trader> traderCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(tTrader -> tTrader.getCity().equalsIgnoreCase("cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .toList();
        traderCambridge.stream().forEach(System.out::println);
        System.out.println("--------------------");
        //Question 07
        /*Trouvez toutes les valeurs des transactions des traders vivant à
        Cambridge : On récupère une liste d’entiers.*/
        System.out.println("Les valeurs des transactions des traders vivant à Cambridge");
        List<Integer> valueTransactCambridge = transactions.stream()
                .filter(t-> t.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .mapToInt(Transaction::getValue)
                .boxed().toList();
        valueTransactCambridge.stream().forEach(System.out::println);
        System.out.println("--------------------");

        //Question 08
        /*Recherchez la transaction avec la plus petite valeur.*/
        System.out.println("Transaction avec la plus petite valeur");
        Transaction transact = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();
        System.out.println(transact);

    }



}
