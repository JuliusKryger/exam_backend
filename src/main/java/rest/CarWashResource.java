package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.WashingAssistantsDTO;
import entities.Booking;
import entities.WashingAssistant;
import errorhandling.API_Exception;
import facades.CarWashFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("carwash")
public class CarWashResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final CarWashFacade instance = CarWashFacade.getCarWashFacade(EMF);
    //private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("washingassistants")
    public String getAllUsers() {
        WashingAssistantsDTO wa = instance.getAllWashingAssistants();
        return GSON.toJson(wa);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bookings/{userName}")
    public String getFoodPlan(@PathParam("userName") String userName) {
        System.out.println(userName);
        Booking booking = instance.getUsersBookings(userName);
        return GSON.toJson(booking);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("washingassistants/create")
    public Response createWashingAssistants (String jsonString) throws API_Exception {
        WashingAssistant washingAssistant = new WashingAssistant();
        String name; String primaryLanguage; int yearsOfExperience; int pricePerHour;
        try {
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            name = json.get("washingassistantName").getAsString();
            washingAssistant.setName(name);
            primaryLanguage = json.get("washingassistantPrimaryLanguage").getAsString();
            washingAssistant.setPrimaryLanguage(primaryLanguage);
            yearsOfExperience = json.get("washingassistantYearsOfExperience").getAsInt();
            washingAssistant.setYearsOfExperience(yearsOfExperience);
            pricePerHour = json.get("washingassistantPricePerHour").getAsInt();
            washingAssistant.setPricePerHour(pricePerHour);
            instance.createWashingAssistant(washingAssistant);
        } catch (Exception e) {
            throw new API_Exception("Invalid input", 400, e);
        }
        return null;
    }

}