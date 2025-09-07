package com.github.sergiooliveirabr.algostruct.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FinalCostDTO {

    // Shipment
    private int internalShipping;
    private double externalShipping;
    private double shipmentCost;

    // Card Payment Fee
    private double serviceCharge;
    private double plataformServiceFee;


    // Product
    private double productPrice;
    private double productFinalPriceCYR;
    private double productFinalPriceEUR;

    public FinalCostDTO(int internalShipping,
                        double externalShipping,
                        double shipmentCost,
                        double serviceCharge,
                        double plataformServiceFee,
                        double productPrice,
                        double productFinalPriceCYR,
                        double productFinalPriceEUR) {

        this.internalShipping = internalShipping;
        this.externalShipping = externalShipping;
        this.shipmentCost = shipmentCost;
        this.serviceCharge = serviceCharge;
        this.plataformServiceFee = plataformServiceFee;
        this.productPrice = productPrice;
        this.productFinalPriceCYR = productFinalPriceCYR;
        this.productFinalPriceEUR = productFinalPriceEUR;
    }
}
