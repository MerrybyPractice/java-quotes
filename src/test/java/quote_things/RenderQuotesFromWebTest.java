package quote_things;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class RenderQuotesFromWebTest {
    @Test
    public void testWebReading() {
        try {
            BufferedReader webReader = RenderQuotes.getWebReader("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");

            assertEquals("webReader should return a valid BufferedReader", BufferedReader.class, webReader.getClass());

            String quoteJson = RenderQuotes.parseQuotes(webReader);
            Gson gson = new Gson();
            WebQuote parsedWebQuote = gson.fromJson(quoteJson, WebQuote.class);

            assertEquals("The returned object should be a WebQuote", WebQuote.class, parsedWebQuote.getClass());

            Quotes[] output = new Quotes[]{parsedWebQuote.convertToQuote()};

            assertEquals("The output array should contain a Quote, not a WebQuote", Quotes[].class, output.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testGetWebQuote() {
        Quotes[] webQuote = new Quotes[0];
        try {
            webQuote = RenderQuotes.getQuotesFromWeb("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("Should be precisely one Quote", 1, webQuote.length);
        assertEquals("Quote should be a Quote, not a WebQuote", Quotes.class, webQuote[0].getClass());
        assertTrue("likes field should end with \" likes\"", webQuote[0].likes.endsWith(" likes"));
    }


}
