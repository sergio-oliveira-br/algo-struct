package com.github.sergiooliveirabr.algostruct.service.calculator;

import org.springframework.stereotype.Service;

@Service
public class InternationalShippingService {

    public double intShippingCalculator (double productWeight) {

        // If the weight is up to 0.200kg (200g), the cost is fixed.
        if (productWeight < 0.200) {
            return 70;
        }

        // From 0.201kg (201g), it needed to calculate the additional cost
        double additionalWeigth = productWeight - 0.200;

        // Determine the quantity of 200g blocks that are added to the weight.
        double numbeOfAdditionalBlocks = Math.ceil(additionalWeigth / 0.200);

        // Each additional block costs 18.
        double additionalCost = numbeOfAdditionalBlocks * 18;

        return additionalCost + 70;
    }
}
