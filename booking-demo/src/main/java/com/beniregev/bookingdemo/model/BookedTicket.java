package com.beniregev.bookingdemo.model;

import java.util.Objects;

public class BookedTicket {
    private int id;
    private String prefix;  //  MR / MS / MRS
    private String fname;
    private String lname;
    private String baggageId;
    private int originationId;  //  airportId of origination
    private int destinationId;  //  airportId of destination
    private double price;

    public BookedTicket(int id, String prefix, String fname, String lname, String baggageId, int originationId, int destinationId, double price) {
        this.id = id;
        this.prefix = prefix;
        this.fname = fname;
        this.lname = lname;
        this.baggageId = baggageId;
        this.originationId = originationId;
        this.destinationId = destinationId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(String baggageId) {
        this.baggageId = baggageId;
    }

    public int getOriginationId() {
        return originationId;
    }

    public void setOriginationId(int originationId) {
        this.originationId = originationId;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookedTicket bookedTicket = (BookedTicket) o;
        return id == bookedTicket.id &&
                originationId == bookedTicket.originationId &&
                destinationId == bookedTicket.destinationId &&
                Double.compare(bookedTicket.price, price) == 0 &&
                Objects.equals(prefix, bookedTicket.prefix) &&
                Objects.equals(fname, bookedTicket.fname) &&
                Objects.equals(lname, bookedTicket.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prefix, fname, lname, originationId, destinationId, price);
    }
}
