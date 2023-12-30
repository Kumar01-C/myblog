package com.redbus.Operator.Util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.redbus.User.Payloads.BookingDetailsDto;

import java.io.ByteArrayOutputStream;

public class PdfGenerator {

    public static byte[] generateBookingConfirmationPdf(BookingDetailsDto bookingDetails) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Booking Confirmation"));
            document.add(new Paragraph("Booking ID: " + bookingDetails.getBookingId()));
            document.add(new Paragraph("Bus Company: " + bookingDetails.getBusCompany()));
            document.add(new Paragraph("Bus Number: " + bookingDetails.getBusNumber()));
            document.add(new Paragraph("From City: " + bookingDetails.getFromCity()));
            document.add(new Paragraph("To City: " + bookingDetails.getToCity()));
            document.add(new Paragraph("Departure Date: " + bookingDetails.getDepartureDate()));
            document.add(new Paragraph("Passenger: " + bookingDetails.getFirstName() + " " + bookingDetails.getLastName()));
            document.add(new Paragraph("Email: " + bookingDetails.getEmail()));
            document.add(new Paragraph("Mobile: " + bookingDetails.getMobile()));
            document.add(new Paragraph("Price: " + bookingDetails.getPrice()));
            // Add more details as needed
            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
            return null;
        }
    }
}
