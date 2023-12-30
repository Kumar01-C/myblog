package com.redbus.Operator.Payloads;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Util.CustomDateDeserializer;
import com.redbus.User.Entity.TicketCost;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.loading.MLetContent;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusOperatorDto {

    private String busId;

    private String busNumber;

    private String busOperatorCompanyName;

    private String driverName;

    private String SupportStaff;

    private int numberSeats;

    private String departureCity;

    private String arrivalCity;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime departureTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime arrivalTime;

    @JsonFormat(pattern = "dd/MM/yyyy")
  //  @JsonDeserialize(using = CustomDateDeserializer.class)

    private Date departureDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
  //  @JsonDeserialize(using = CustomDateDeserializer.class)

    private Date arrivalDate;

    private double totalTravelTime;

    private String busType;

    private String amenities;

    private TicketCost ticketCost;

//    private String ticketId;
//
//    private BusOperator busOperator;
//    private String code;
//    private Double price;
//    private Double discountAmount;


}
