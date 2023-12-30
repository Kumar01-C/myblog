package com.redbus.User.Payloads;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusListDto {


        private String busNumber;

        private String busOperatorCompanyName;

        private int numberSeats;

        private String departureCity;

        private String arrivalCity;

        private LocalTime departureTime;

        private LocalTime arrivalTime;

        private Date departureDate;

        private Date arrivalDate;

        private double totalTravelTime;

        private String busType;

        private String amenities;



}
