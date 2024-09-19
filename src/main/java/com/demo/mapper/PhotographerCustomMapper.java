package com.demo.mapper;


import com.demo.dto.*;
import com.demo.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PhotographerCustomMapper {

    Photographer toPhotographer(PhotographerDTO photographerDTO);

    Address toAddress(AddressDTO addressDTO);

    CreditCard toCreditCard(CreditCardDTO creditCardDTO);

    Subscription toSubscription(SubscriptionDTO subscriptionDTO);

    EventType toEventType(EventTypeDTO eventTypeDTO);

}
