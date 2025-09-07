package com.github.sergiooliveirabr.algostruct.service.calculator;

import com.github.sergiooliveirabr.algostruct.dto.FinalCostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorOrchestrator {

    private final DomesticShippingService domesticShippingService;
    private final InternationalShippingService internationalShippingService;

    @Autowired
    public CalculatorOrchestrator(DomesticShippingService domesticShippingService,
                                  InternationalShippingService internationalShippingService) {

        this.domesticShippingService = domesticShippingService;
        this.internationalShippingService = internationalShippingService;
    }

    public FinalCostDTO calculator(int domesticShippingfixedFee, double productWeight) {

        if (productWeight <= 0) {
            throw new IllegalArgumentException("Produt Weight must be greater than zero");
        }

        int domesticFee = domesticShippingService.domShippingCalculator(domesticShippingfixedFee);
        double internationalFee = internationalShippingService.intShippingCalculator(productWeight);
        double shipmentFee = domesticFee + internationalFee;

        return new FinalCostDTO(domesticFee, internationalFee, shipmentFee);
    }
}
