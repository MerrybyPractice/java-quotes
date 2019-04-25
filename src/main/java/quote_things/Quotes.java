package quote_things;

public class Quotes {

    public String[] tags;
    public String author;
    public String likes;
    public String text;

    public String toString() {
        String stringyQuote = "\"";

        stringyQuote += text;
        stringyQuote += "\" \n -";
        stringyQuote += author;
        stringyQuote += "\ntags:";
        for (String tag : tags) {
            stringyQuote += " " + tag;
        }
        stringyQuote += "\n";
        stringyQuote += likes;

        return stringyQuote;
    }
}
