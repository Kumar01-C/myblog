package com.redbus.User.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Bookings")
public class BookingDetails {

    @Id
    @Column(name="booking_id")
    private String bookingId;
    @Column(name="bus_id")
    private String busId;
    @Column(name="ticket_id")
    private String ticketId;
    @Column(name="bus_company")
    private String busCompany;
    @Column(name="bus_number")
    private String busNumber;
    @Column(name="from_city")
    private String fromCity;
    @Column(name="to_city")
    private String toCity;
    @Temporal(TemporalType.DATE)
    @Column(name="departure_date")
    private Date departureDate;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="mobile")
    private String mobile;
    @Column(name="price")
    private double price;
}
