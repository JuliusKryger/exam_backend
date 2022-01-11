package dtos;

public class ApiMergeDTO {

    private AnimeFactDTO animeFactDTO;
    private AnimeQuoteDTO animeQuoteDTO;

    public ApiMergeDTO(AnimeFactDTO animeFactDTO, AnimeQuoteDTO animeQuoteDTO) {
        this.animeFactDTO = animeFactDTO;
        this.animeQuoteDTO = animeQuoteDTO;
    }

    public AnimeFactDTO getAnimeFactDTO() {
        return animeFactDTO;
    }

    public void setAnimeFactDTO(AnimeFactDTO animeFactDTO) {
        this.animeFactDTO = animeFactDTO;
    }

    public AnimeQuoteDTO getAnimeQuoteDTO() {
        return animeQuoteDTO;
    }

    public void setAnimeQuoteDTO(AnimeQuoteDTO animeQuoteDTO) {
        this.animeQuoteDTO = animeQuoteDTO;
    }
}
