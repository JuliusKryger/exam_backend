package rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nimbusds.jose.shaded.json.JSONObject;
import dtos.AnimeFactDTO;
import dtos.AnimeQuoteDTO;
import dtos.ApiMergeDTO;
import utils.EMF_Creator;
import utils.HttpUtils;
import utils.Utility;

@Path("anime")
public class AnimeResources {

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@RolesAllowed("user") //Should this be available to all or only to one?
    public String animeContent() throws IOException {
        Gson gson = new Gson();
        String fact = HttpUtils.fetchData("https://anime-facts-rest-api.herokuapp.com/api/v1/demon_slayer/3");
        JsonObject jsonObject = new JsonParser().parse(fact).getAsJsonObject();
        AnimeFactDTO animeFactDTO = gson.fromJson(jsonObject.get("data"), AnimeFactDTO.class);
        String quote = HttpUtils.fetchData("https://animechan.vercel.app/api/random");
        AnimeQuoteDTO animeQuoteDTO = gson.fromJson(quote, AnimeQuoteDTO.class);
        ApiMergeDTO apiMergeDTO = new ApiMergeDTO(animeFactDTO, animeQuoteDTO);
        String combinedJSON = gson.toJson(apiMergeDTO);
        return combinedJSON;
    }
}
