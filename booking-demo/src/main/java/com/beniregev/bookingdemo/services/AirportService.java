package com.beniregev.bookingdemo.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AirportService {
    private Map<Integer, String> airports = new HashMap<>();

    public void intiData() {
        airports.put(1, "Israel, Tel Aviv");
        airports.put(2, "Israel, Ramon");
        airports.put(3, "Ukraine, Kiev");
        airports.put(4, "Ukraine, Dnepro");
        airports.put(5, "Ukraine, Odessa");
        airports.put(6, "Russia, Moscow");
        airports.put(7, "Russia, Saint Petersburg");
        airports.put(8, "USA, NY");
        airports.put(9, "USA, Boston");
        airports.put(10, "USA, LAX");
        airports.put(11, "Mexico, Mexico City");
        airports.put(12, "India, Mumbai");
        airports.put(13, "China, Beigin");
        airports.put(14, "UK, London");
        airports.put(15, "Ireland, Dublin");
        airports.put(16, "Egipt, Cairo");
        airports.put(17, "Hunary, Budapest");
        airports.put(18, "Spain, Madrid");
        System.out.println("Airports list: ");
        airports.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("-------------------------------------------------");
    }

    public  Map<Integer, String> getAllAirports() {
        return airport;
    }

    public boolean isAirportExist(int airportId) {
        return (airports.get(airportId) != null);
    }
}
