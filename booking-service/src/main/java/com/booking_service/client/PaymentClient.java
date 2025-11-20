package com.booking_service.client;

import com.booking_service.dto.ProductRequest;
import com.booking_service.dto.StripeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @PostMapping("/product/v1/checkout")
    StripeResponse checkoutProducts(@RequestBody ProductRequest productRequest);
}
