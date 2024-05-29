package exercice.proxy;

public class Client {
    private SecuredBookProxy securedBookProxy;
    public Client(SecuredBookProxy securedBookProxy) {
        this.securedBookProxy = securedBookProxy;
    }

    public SecuredBookProxy getSecuredBookProxy() {
        return securedBookProxy;
    }

    public void setSecuredBookProxy(SecuredBookProxy securedBookProxy) {
        this.securedBookProxy = securedBookProxy;
    }
}
