package com.beniregev.bookingdemo;

import com.beniregev.bookingdemo.model.BookedTicket;
import com.beniregev.bookingdemo.services.AirportService;
import com.beniregev.bookingdemo.services.BookingTicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/bookings")
public class BookingController {

    @Autowired
    private BookingTicketsService bookingTicketsService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private BaggageCheckinService baggageCheckinService;

    public BookingController() {
        airportService.intiData();
        bookingTicketsService.intiData();
    }

    @RequestMapping(value = "/bookedtickets/all", method = RequestMethod.GET)
    public List<BookedTicket> getAll() {
        return bookingTicketsService.getAll();
    }

    /**
     * Check if ticket is available:
     * a1. User Provide TicketId(Numeric) and return response (boolean) whether the ticket is
     * available or not (the response will determine upon your predefined static data)
     * @param ticketId
     * @return
     */
    @RequestMapping(value = "/ticketId/{ticketId}", method = RequestMethod.GET)
    public Boolean isticketAvailable(@PathVariable int ticketId) {
        return bookingTicketsService.isticketAvailable(ticketId);
    }

    @RequestMapping(value = "/baggagecheckin/destinationId/{destinationId}", method = RequestMethod.GET)
    public Boolean baggageCheckin(@PathVariable int ticketId) {
        return bookingTicketsService.baggageCheckin();
    }

    @RequestMapping(value = "/airports/isexist/{airportId}", method = RequestMethod.GET)
    public Boolean isAirportExist(int airportId) {
        return airportService.isAirportExist(airportId);
    }

    public boolean isBaggageExist(String baggageId) {
        return (bookingTicketsService.isBaggageExist(baggageId));
    }

}
