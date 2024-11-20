package com.demo.repository;

import com.demo.entity.Photographer;

import java.util.List;

public interface PhotographerCustomRepository {

    List<Photographer> getPhotographersWithActiveSubscription();
}
