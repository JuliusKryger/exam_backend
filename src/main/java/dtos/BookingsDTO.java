package dtos;

import entities.WashingAssistant;

import java.util.ArrayList;
import java.util.List;

public class BookingsDTO {

    //Variables
    List<BookingDTO> all = new ArrayList();

    //Constructors
    public WashingAssistantsDTO(List<WashingAssistant> washingAssistantList) {
        washingAssistantList.forEach((wa) -> {
            all.add(new WashingAssistantDTO(wa));
        });
    }

    //methods
    public List<WashingAssistantDTO> getAll() {
        return all;
    }

    //toString
    @Override
    public String toString() {
        return "WashingAssistantsDTO{" +
                "all=" + all +
                '}';
    }
}
