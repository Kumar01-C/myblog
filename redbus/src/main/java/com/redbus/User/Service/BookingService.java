package com.redbus.User.Service;

import com.redbus.Operator.Entity.BusOperator;
import com.redbus.Operator.Exception.ResourceNotFoundException;
import com.redbus.Operator.Repository.BusOperatorRepository;
import com.redbus.Operator.Repository.TicketCostRepository;
import com.redbus.User.Entity.BookingDetails;
import com.redbus.User.Entity.TicketCost;
import com.redbus.User.Payloads.BookingDetailsDto;
import com.redbus.User.Payloads.PassengerDetails;
import com.redbus.User.Repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    private BookingRepository bookingRepository;


    private BusOperatorRepository busOperatorRepository;

    private TicketCostRepository ticketCostRepository;

    public BookingService(BookingRepository bookingRepository, BusOperatorRepository busOperatorRepository, TicketCostRepository ticketCostRepository) {
        this.bookingRepository = bookingRepository;
        this.busOperatorRepository = busOperatorRepository;
        this.ticketCostRepository = ticketCostRepository;
    }


    public BookingDetailsDto createBooking(String busId, String ticketId, PassengerDetails passengerDetails) {
        BusOperator buses = busOperatorRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFoundException("not found"+busId));
        TicketCost ticketCost = ticketCostRepository.findById(ticketId).orElseThrow(
                () -> new ResourceNotFoundException("not found" + busId));


        BookingDetails booking = new BookingDetails();
        String bookingId = UUID.randomUUID().toString();
        booking.setBookingId(bookingId);
        booking.setBusNumber(buses.getBusNumber());
        booking.setBusId(buses.getBusId());
        booking.setBusCompany(buses.getBusOperatorCompanyName());
        booking.setFromCity(buses.getDepartureCity());
        booking.setToCity(buses.getArrivalCity());
        booking.setDepartureDate(buses.getDepartureDate());
        booking.setTicketId(ticketCost.getTicketId());
        booking.setPrice(ticketCost.getPrice());
        booking.setFirstName(passengerDetails.getFirstName());
        booking.setLastName(passengerDetails.getLastName());
        booking.setEmail(passengerDetails.getEmail());
        booking.setMobile(passengerDetails.getMobile());

        BookingDetails ticketsBooked = bookingRepository.save(booking);

        BookingDetailsDto dto = new BookingDetailsDto();

        dto.setBookingId(ticketsBooked.getBookingId());
        dto.setBusId(ticketsBooked.getBusId());
        dto.setBusCompany(ticketsBooked.getBusCompany());
        dto.setBusNumber(ticketsBooked.getBusNumber());
        dto.setFromCity(ticketsBooked.getFromCity());
        dto.setToCity(ticketsBooked.getToCity());
        dto.setDepartureDate(ticketsBooked.getDepartureDate());
        dto.setTicketId(ticketsBooked.getTicketId());
        dto.setPrice(ticketsBooked.getPrice());
        dto.setFirstName(ticketsBooked.getFirstName());
        dto.setLastName(ticketsBooked.getLastName());
        dto.setEmail(ticketsBooked.getEmail());
        dto.setMobile(ticketsBooked.getMobile());

        return dto;
    }
}
