package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
    private String city;
    private String street_name;
    private String street_address;
    private String zip_code;
    private String state;
    private String country;
    private Double coordinates_lat;
    private Double coordinates_lng;

    @JsonProperty("coordinates")
    private void unpackNameFromNestedObject(Map<String, Object> coordinates) {
        coordinates_lat = Optional.ofNullable(coordinates.get("lat")).map(x -> (Double) x).orElse(0.0d);
        coordinates_lng = Optional.ofNullable(coordinates.get("lng")).map(x -> (Double) x).orElse(0.0d);
    }
}
