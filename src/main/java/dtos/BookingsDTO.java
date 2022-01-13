package dtos;

import entities.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingsDTO {

    //Variables
    List<BookingDTO> all = new ArrayList();

    //Constructors
    public BookingsDTO(List<Booking> bookingList) {
        bookingList.forEach((b) -> {
            all.add(new BookingDTO(b));
        });
    }

    //methods
    public List<BookingDTO> getAll() {
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
