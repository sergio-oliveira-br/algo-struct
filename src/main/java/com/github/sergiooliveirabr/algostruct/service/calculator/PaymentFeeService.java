package com.github.sergiooliveirabr.algostruct.service.calculator;

import org.springframework.stereotype.Service;

@Service
public class PaymentFeeService {

    private static final double PLATAFORM_RATE_PERCENTAGE = 0.025;
    private static final double EXCHANGE_RATE_FEE_PERCENTAGE = 0.04; // 4%
    private static final double CYR_FEE = 2.5; // 2.5 CYR

    public double serviceChargeService(double productPrice) {

        if(productPrice < 0) {
            throw new IllegalArgumentException("Product Price must be greater than zero");
        }
        return productPrice * EXCHANGE_RATE_FEE_PERCENTAGE + CYR_FEE;
    }

    public double plataformServiceFeeService(double productPrice) {

        if(productPrice < 0) {
            throw new IllegalArgumentException("Product Price must be greater than zero");
        }
        return productPrice * PLATAFORM_RATE_PERCENTAGE;
    }
}
