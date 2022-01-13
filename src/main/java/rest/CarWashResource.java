package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.WashingAssistantsDTO;
import entities.Booking;
import facades.CarWashFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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



}