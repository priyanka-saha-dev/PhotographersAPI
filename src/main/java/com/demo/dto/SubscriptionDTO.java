package com.demo.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubscriptionDTO {

    private String plan;
    private String status;
    private String payment_method;
    private String term;
}
