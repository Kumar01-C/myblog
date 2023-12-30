package com.redbus.User.Controller;

import com.redbus.Operator.Util.EmailService;
import com.redbus.Operator.Util.PdfGenerator;
import com.redbus.User.Payloads.BookingDetailsDto;
import com.redbus.User.Payloads.PassengerDetails;
import com.redbus.User.Service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {


    private BookingService bookingService;

    private EmailService emailService;

    public BookingController(BookingService bookingService, EmailService emailService) {
        this.bookingService = bookingService;
        this.emailService = emailService;
    }


    // http://localhost:8080/api/bookings?busId=&ticketId=
    @PostMapping
    public ResponseEntity<BookingDetailsDto> createBooking(
            @RequestParam("busId") String busId,
            @RequestParam("ticketId") String ticketId,
            @RequestBody PassengerDetails passengerDetails
    ) {
        BookingDetailsDto bookings = bookingService.createBooking(busId, ticketId, passengerDetails);
        if (bookings != null) {
            // Generate iText PDF
            byte[] pdfBytes = PdfGenerator.generateBookingConfirmationPdf(bookings);

            // Send Email with PDF attachment
            emailService.sendEmailWithAttachment(
                    passengerDetails.getEmail(),
                    "Booking Confirmation - " + bookings.getBookingId(),
                    "Booking details are attached.",
                    pdfBytes,
                    "BookingConfirmation.pdf"
            );
        }

        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
