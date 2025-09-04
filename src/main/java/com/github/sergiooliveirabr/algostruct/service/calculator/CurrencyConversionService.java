package com.github.sergiooliveirabr.algostruct.service.calculator;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

    private final String API_KEY = "7e63115a823ed6ad94cdfaf2";
    private final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/EUR";

    public double getExchangeRate(String targetCurrency) {

        RestTemplate restTemplate = new RestTemplate();
        try {
            JsonNode response = restTemplate.getForObject(API_URL, JsonNode.class);
            if (response != null) {
                return response.get("conversion_rates").get(targetCurrency).asDouble();
            }
        } catch (Exception e) {
           throw new RuntimeException("Error in obtaining the exchange rate: " + e);
        }
        return 0;
    }
}
