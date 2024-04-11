package org.exercice;

public class Adn {
    public static void main(String[] args) {
        // Saisies
        String chaineAdn = saisieChaineAdn("Saisir la chaine : ");
        String sequence = saisieChaineAdn("Saisir la séquence : ");

        System.out.println("chaine : " + chaineAdn);
        System.out.println("sequence : " + sequence);

        // Calcul
        double pourcentage = pourcentageSequence(chaineAdn, sequence);
        System.out.println("Pourcentage : " + pourcentage);
    }

    public static boolean verificationAdn(String chaineAdn){
        for(int i = 0; i < chaineAdn.length(); i++){
            if(!"actg".contains(Character.toString(chaineAdn.charAt(i))))
                return false;
        }
        return true;
    }

    public static <Scanner> String saisieChaineAdn(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String chaine = scanner.nextLine().trim().toLowerCase();
        while(!verificationAdn(chaine)){
            System.out.println("Erreur ! " + message);
            chaine = scanner.nextLine().trim().toLowerCase();
        }
        return chaine;
    }

    public static double pourcentageSequence(String chaine, String sequence){
        Pattern pattern = Pattern.compile(sequence);
        Matcher matcher = pattern.matcher(chaine);
        int occurrences = 0;
        while (matcher.find()) {
            occurrences++;
        }
        double pourcentage = (double) occurrences * sequence.length() / chaine.length() * 100;
        return pourcentage;
    }
}
