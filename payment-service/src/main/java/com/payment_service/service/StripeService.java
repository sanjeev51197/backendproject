package com.payment_service.service;

import com.payment_service.dto.ProductRequest;
import com.payment_service.dto.StripeResponse;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe.secretKey}")
    private String secretKey;

    public StripeResponse checkoutProducts(ProductRequest productRequest){

        Stripe.apiKey=secretKey;

        //creating paymentIntent with order amount and currency
        SessionCreateParams.LineItem.PriceData.ProductData productData=SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(productRequest.getName())
                .build();

        //creating new line with above product data and associated price

        SessionCreateParams.LineItem.PriceData priceData=SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(productRequest.getCurrency()!=null?productRequest.getCurrency() :"USD")
                .setUnitAmount(productRequest.getAmount())
                .setProductData(productData)
                .build();

        // creating new line item with above price data

        SessionCreateParams.LineItem lineItem=SessionCreateParams.LineItem.builder()
                .setQuantity(productRequest.getQuantity())
                .setPriceData(priceData)
                .build();

        //creating new session with line item
        SessionCreateParams params=SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8080/success")
                .setCancelUrl("http://localhost:8080/cancel")
                .addLineItem(lineItem)
                .build();

        //creating new session
        Session session=null;
        try {
            session=Session.create(params);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        StripeResponse sr=new StripeResponse();
        sr.setStatus("Success");
        sr.setMessage("Payment session created");
        sr.setSessionId(session.getId());
        sr.setSessionUrl(session.getUrl());
        return sr;





    }
}
