package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PHOTOGRAPHER")
@Slf4j
public class Photographer {

    @Id
    private Integer id;

    @Column(unique = true, nullable = false)
    private String uid;

    @Column(nullable = false)
    private String password;

    private String first_name;
    private String last_name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String avatar;
    private String gender;
    private String phone_number;
    private String social_insurance_number;

    @Temporal(TemporalType.DATE)
    private Date date_of_birth;

//    private LocalDate date_of_birth1; // Temporal annotation is not needed for JAVA 8

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    @JsonManagedReference
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id")
//    @JsonManagedReference
    private CreditCard credit_card;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
//    @JsonManagedReference
    private Subscription subscription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "photographer_event_types",
            joinColumns = @JoinColumn(name = "photographer_id"),
            inverseJoinColumns = @JoinColumn(name = "event_type_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"event_type_id", "photographer_id"}) // needed ??
    )
//    @JsonManagedReference
    private List<EventType> eventTypes;

    @JsonProperty("event_type")
    private void unpackNameFromNestedObject(Map<String, ArrayList<String>> events) {
        if(events != null && events.containsKey("type") && events.get("type") != null) {
            eventTypes = events.get("type").stream().map(e -> EventType.builder().event(e).build()).toList();
        }
    }

}
