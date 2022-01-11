package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ZooDTO;
import dtos.ZoosDTO;
import facades.ZooFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/zoo")
public class ZooResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ZooFacade FACADE = ZooFacade.getZooFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("/status")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String status() {
        return "{\"msg\":\"API is up and running.\"}";
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createNewZoo(String zoo) {
        ZooDTO zooDTO = GSON.fromJson(zoo, ZooDTO.class);
        ZooDTO newZoo = FACADE.createZoo(zooDTO);
        return GSON.toJson(newZoo);
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getZooById(@PathParam("id") int id) {
        ZooDTO zooDTO  = FACADE.getZooById(id);
        return GSON.toJson(zooDTO);
    }

    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllZoos() {
        ZoosDTO zoosDTO = FACADE.getAllZoos();
        return GSON.toJson(zoosDTO);
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteZoo(@PathParam("id") int id) {
        return "This Zoo -> (" + FACADE.deleteZooById(id) + ") is here by deleted.";
    }

    @Path("/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateZoo(@PathParam("id") int id, String zoo) {
        ZooDTO zooDTO = GSON.fromJson(zoo, ZooDTO.class);
        zooDTO.setId(id);
        ZooDTO updatedZoo = FACADE.updateZooName(zooDTO);
        return GSON.toJson(updatedZoo);
    }
}