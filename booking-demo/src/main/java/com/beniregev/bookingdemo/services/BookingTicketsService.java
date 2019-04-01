package com.beniregev.bookingdemo.services;

import com.beniregev.bookingdemo.BookingController;
import com.beniregev.bookingdemo.model.BookedTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingTicketsService {

    @Autowired
    private BookingController bookingController;

    private List<Double>  coupons = new ArrayList<>(); //  coupons discount percent
    private Map<Integer, BookedTicket> bookings = new HashMap<>();

    public void intiData() {
        coupons.add(10.0);
        coupons.add(2.5);
        coupons.add(12.5);
        coupons.add(20.0);
        coupons.add(22.0);
        coupons.add(42.0);
        coupons.add(27.5);
        coupons.add(30.0);
        coupons.add(17.0);
        coupons.add(13.0);
        coupons.add(20.75);
        coupons.add(21.2);
        coupons.add(40.0);

        newBookedTicket(1, "MR", "John", "Smith", "baggege1", 1, 3, 244.5);
        newBookedTicket(2, "MRS", "Jane", "Smith", 1, 3, 244.5);
        newBookedTicket(3, "MR", "John", "Dow", 1, 6, 456.95);
        newBookedTicket(4, "MRS", "Jane", "Dow", 1, 6, 456.95);
        newBookedTicket(5, "MS", "Sarah", "Imenu", 1, 10, 1234.95);
        newBookedTicket(6, "MR", "Avi", "Avinu", 1, 10, 1234.95);
        newBookedTicket(7, "MR", "Moshe", "Rabenu", 1, 16, 149.95);
        newBookedTicket(8, "MR", "Miriam", "Bat Amram", 1, 17, 600.95);
        newBookedTicket(9, "MR", "David", "Ben Yishai", 1, 3, 999.95);

        System.out.println("Booked Tickets list: ");
        bookings.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("-------------------------------------------------");
    }

    public void newBookedTicket(int id, String prefix, String fname, String lname, int originationId, int destinationId, double price) {
        BookedTicket ticket = new BookedTicket(id, prefix, fname, lname, originationId, destinationId, price);
        bookings.put(ticket.getId(), ticket);
    }

    public List<BookedTicket> getAll() {
        return bookings
                .entrySet()
                .stream()
                .collect(Collectors.toList());
    }

    public Boolean isticketExist(int ticketId) {
        return (bookings.get(ticketId) != null);
    }

    public Boolean isticketAvailable(int ticketId) {
        return !isticketExist(ticketId);
    }

    public boolean isBaggageExist(String baggageId) {
        List<BookedTicket> bookedTickets = bookings.entrySet().stream()
                .filter(x -> x.getValue().getBaggageId().equals(baggageId))
                .map(map -> map.getValue())
                .collect(Collectors.toList());
        return (bookedTickets.size() > 0);
    }

    public double getPriceAfterDiscount(int couponId) {

    }

    /**
     * <p>
     * Provide baggage check in service - 10 points
     * b1. User provide Destination Id(Numeric) and baggage Id(String)
     * b2. Return answer if the checkin succeeded (boolean) <br/>
     * Baggage-checkin is successful only when destinationId (destination airport) or baggageId exist.
     * </p>
     * @param destinationId
     * @param baggageId
     * @return
     */
    public Boolean baggageCheckin(int destinationId, String baggageId) {
        if (!bookingController.isAirportExist(destinationId)) {
            return Boolean.FALSE;
        }
        if (!bookingController.isBaggageExist(baggageId)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
