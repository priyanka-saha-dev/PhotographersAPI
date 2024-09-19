package com.demo.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhotographerDTO {

    private Integer id;
    private String uid;
    private String password;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    private String phone_number;
    private String social_insurance_number;
    private Date date_of_birth;
    private AddressDTO address;
    private CreditCardDTO credit_card;
    private SubscriptionDTO subscription;
    private List<EventTypeDTO> eventTypes;

}
