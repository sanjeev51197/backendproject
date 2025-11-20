package com.booking_service.controller;

import com.booking_service.client.DoctorClient;
import com.booking_service.client.PatientClient;
import com.booking_service.client.PaymentClient;
import com.booking_service.dto.*;
import com.booking_service.entity.BookingConfirmation;
import com.booking_service.repository.BookingConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private DoctorClient doctorClient;
    @Autowired
    private PatientClient patientClient;

    @Autowired
    private PaymentClient paymentClient;
    @Autowired
    private BookingConfirmationRepository  bookingConfirmationRepository;

    //http://localhost:8085/api/v1/booking/book?doctorId=1&patientId=1&date=2025-11-208&time=21:00
    @GetMapping("/book")
    public StripeResponse getDoctorById(
            @RequestParam long doctorId,
            @RequestParam long patientId,
            @RequestParam LocalDate date,
            @RequestParam LocalTime time) {
        Patient p = patientClient.getPatientById(patientId);
        Doctor d = doctorClient.getDoctorById(doctorId);
        BookingConfirmation bookingConfirmation = new BookingConfirmation();
        bookingConfirmation.setDoctorName(d.getName());
        bookingConfirmation.setPatientName(p.getName());
        bookingConfirmation.setAddress(d.getAddress());

        List<DoctorAppointmentSchedule> appointmentSchedules = d.getAppointmentSchedules();
        for (DoctorAppointmentSchedule app : appointmentSchedules) {
            LocalDate localDate = app.getDate();
            if (localDate.isEqual(date)) {
                List<TimeSlots> timeSlots = app.getTimeSlots();
                for (TimeSlots t : timeSlots) {
                    if (t.getTime().equals(time))   //t.getTime() returns LocalTime and  time is your input LocalTime
                    {
                         bookingConfirmation.setDate(date);
                         bookingConfirmation.setTime(time);
                     //   System.out.println("Complete Booking");
                    }
                }
            }

        }
        //save booking confirmation
         BookingConfirmation savedBookingConfirmation =bookingConfirmationRepository.save(bookingConfirmation);

        ProductRequest pr=new ProductRequest();
        pr.setName(bookingConfirmation.getPatientName());
        pr.setAmount(8000);
        pr.setCurrency("INR");
        pr.setQuantity(1L);
        pr.setBookingId(savedBookingConfirmation.getId());

      StripeResponse stripeResponse=  paymentClient.checkoutProducts(pr);
         return stripeResponse;

    }


    @GetMapping("/bookingid")
    public BookingConfirmation getBookingById(
            @RequestParam long bookingId)
    {
        return bookingConfirmationRepository.findById(bookingId).get();
    }

    @PutMapping("/updatestatus")
    public void confirmBooking(@RequestBody BookingConfirmation bookingConfirmation)
    {
        bookingConfirmationRepository.save(bookingConfirmation);
    }
}
