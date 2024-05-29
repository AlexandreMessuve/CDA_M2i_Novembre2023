package exercice.proxy;

public class SecuredBookProxy implements Book{
    private RealBook book;
    private boolean isUserPremium;
    public SecuredBookProxy(String title, String content, boolean isUserPremium) {
        book = new RealBook(title, content);
        this.isUserPremium = isUserPremium;
    }

    @Override
    public String readBook() {
        if (isUserPremium) {
            return book.readBook();
        } else{
            return "Vous n'avez pas l'abonnement premium";
        }
    }
}
