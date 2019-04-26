package quote_things;

public class WebQuote extends Quotes {
    String quoteText;
    String quoteAuthor;

    public String toString() {
        String output = " “";
        output += quoteText;
        output += "” \n -";
        output += quoteAuthor;
        output += "\ntags: \n0 Likes";

        return output;
    }

    public Quotes convertToQuote() {
        Quotes output = new Quotes();
        output.tags = new String[]{};
        output.author = quoteAuthor;
        output.likes = "0 Likes";
        output.text = quoteText;

        return output;
    }
}
