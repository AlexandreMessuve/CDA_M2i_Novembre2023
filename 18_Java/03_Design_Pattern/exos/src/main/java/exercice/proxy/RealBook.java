package exercice.proxy;

public class RealBook implements Book{

    private final String title;
    private final String content;

    public RealBook(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Override
    public String readBook() {
        return title + ": " + content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
