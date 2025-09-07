package com.github.sergiooliveirabr.algostruct.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FinalCostDTO {

    private int internalShipping;
    private double externalShipping;
    private double shipmentCost;


    public FinalCostDTO(int internalShipping, double externalShipping, double shipmentCost) {
        this.internalShipping = internalShipping;
        this.externalShipping = externalShipping;
        this.shipmentCost = shipmentCost;
    }
}
