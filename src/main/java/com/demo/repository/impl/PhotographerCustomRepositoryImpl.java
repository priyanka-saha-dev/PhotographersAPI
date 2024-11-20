package com.demo.repository.impl;

import com.demo.entity.Photographer;
import com.demo.repository.PhotographerCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PhotographerCustomRepositoryImpl implements PhotographerCustomRepository {

    private final EntityManager entityManager;

    public PhotographerCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Photographer> getPhotographersWithActiveSubscription() {

        String jpql = "SELECT p FROM Photographer p WHERE ..."; // Custom query logic here
        TypedQuery<Photographer> query = entityManager.createQuery(jpql, Photographer.class);
        return query.getResultList();

    }
}
