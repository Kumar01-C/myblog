package com.redbus.User.Payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailsDto {

    private String bookingId;

    private String busId;
    private String ticketId;
    private String busCompany;
    private String busNumber;
    private String fromCity;
    private String toCity;
    private Date departureDate;

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;

    private double price;
}
