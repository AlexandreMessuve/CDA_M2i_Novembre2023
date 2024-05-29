package exercice.proxy;

public class Main {
    public static void main(String[] args) {
        SecuredBookProxy proxy = new SecuredBookProxy("Titre", "Content", false);
        SecuredBookProxy proxy2 = new SecuredBookProxy("Titre", "Contenu", true);
        Client client = new Client(proxy);
        Client client2 = new Client(proxy2);
        System.out.println(client.getSecuredBookProxy().readBook());
        System.out.println(client2.getSecuredBookProxy().readBook());
    }
}
