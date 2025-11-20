package com.payment_service.client;

import com.payment_service.dto.BookingConfirmation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingClient {

    @GetMapping ("/api/v1/booking/bookingid")
    public BookingConfirmation getBookingById(@RequestParam long bookingId);

    @PutMapping("/api/v1/booking/updatestatus")
    public void confirmBooking(@RequestBody BookingConfirmation bookingConfirmation);
}


