package com.demo.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreditCardDTO {
    private String cc_number;
}
