package dtos;

public class AnimeQuoteDTO {

    /** This is the free API used for the Anime quotes "https://animechan.vercel.app/guide" **/

    //This is our variables.
    private String quote;

    //The constructor.
    public AnimeQuoteDTO(String quote) {
        this.quote = quote;
    }

    //getter and setters
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
