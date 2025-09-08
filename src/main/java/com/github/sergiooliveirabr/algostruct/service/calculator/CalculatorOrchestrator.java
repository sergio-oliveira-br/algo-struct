package com.github.sergiooliveirabr.algostruct.service.calculator;

import com.github.sergiooliveirabr.algostruct.dto.FinalCostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorOrchestrator {

    private final DomesticShippingService domesticShippingService;
    private final InternationalShippingService internationalShippingService;
    private final PaymentFeeService paymentFeeService;
    private final CurrencyConversionService currencyConversionService;

    @Autowired
    public CalculatorOrchestrator(DomesticShippingService domesticShippingService,
                                  InternationalShippingService internationalShippingService,
                                  PaymentFeeService paymentFeeService,
                                  CurrencyConversionService currencyConversionService) {

        this.domesticShippingService = domesticShippingService;
        this.internationalShippingService = internationalShippingService;
        this.paymentFeeService = paymentFeeService;
        this.currencyConversionService = currencyConversionService;
    }

    public FinalCostDTO calculator(int domesticShippingfixedFee, double productWeight, double productPrice) {

        if (productWeight <= 0 || productPrice <= 0 || domesticShippingfixedFee <= 0) {
            throw new IllegalArgumentException("Weight, Price and Domestic Fee must be greater than zero");
        }

        // Shipment Fee
        int domesticFee = domesticShippingService.domShippingCalculator(domesticShippingfixedFee);
        double internationalFee = internationalShippingService.intShippingCalculator(productWeight);
        double shipmentFee = domesticFee + internationalFee;

        // Payment Fee
        double serviceCharge = paymentFeeService.serviceChargeService(productPrice);
        double plataformServiceFee = paymentFeeService.plataformServiceFeeService(productPrice);

        // Sum (¥)
        double productFinalPriceCYR = shipmentFee + serviceCharge + plataformServiceFee + productPrice;

        // Conversion - CYR to EUR
        double productFinalPriceEUR = productFinalPriceCYR / currencyConversionService.getExchangeRate("CNY");

        return new FinalCostDTO(
                domesticFee,
                internationalFee,
                shipmentFee,
                serviceCharge,
                plataformServiceFee,
                productPrice,
                productFinalPriceCYR,
                productFinalPriceEUR);
    }
}