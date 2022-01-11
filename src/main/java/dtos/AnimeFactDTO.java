package dtos;

public class AnimeFactDTO {

    //Here is our variables.
    private String fact;

    //This is the constructor
    public AnimeFactDTO(String fact) {
        this.fact = fact;
    }

    //This is our getters and setters.
    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
