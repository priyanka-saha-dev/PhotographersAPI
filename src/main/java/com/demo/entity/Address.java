package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String city;
    private String street_name;
    private String street_address;
    private String zip_code;
    private String state;
    private String country;

    private Double coordinates_lat;
    private Double coordinates_lng;

    @OneToOne(mappedBy = "address")
//    @JsonBackReference
    @JsonIgnore
    private Photographer photographer;

    @JsonProperty("coordinates")
    private void unpackNameFromNestedObject(Map<String, Object> coordinates) {
        coordinates_lat = Optional.ofNullable(coordinates.get("lat")).map(x -> (Double) x).orElse(0.0d);
        coordinates_lng = Optional.ofNullable(coordinates.get("lng")).map(x -> (Double) x).orElse(0.0d);
    }
}
