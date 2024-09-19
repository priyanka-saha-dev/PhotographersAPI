package com.demo.service.impl;

import com.demo.entity.EventType;
import com.demo.entity.Photographer;
import com.demo.repository.EventTypeRepository;
import com.demo.repository.PhotographerRepository;
import com.demo.service.PhotographersService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class PhotographersServiceImpl implements PhotographersService {

    private final PhotographerRepository photographerRepository;
    private final EventTypeRepository eventTypeRepository;

    public PhotographersServiceImpl(PhotographerRepository photographerRepository, EventTypeRepository eventTypeRepository) {
        this.photographerRepository = photographerRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    @Override
    @Transactional
    public Boolean upload(List<Photographer> photographers) {
        AtomicReference<Boolean> isAllUpdated = new AtomicReference<>(Boolean.FALSE);
        photographers.forEach(photographer -> {

            List<EventType> events = photographer.getEventTypes().stream().map(eventType -> {
                Optional<EventType> event = this.eventTypeRepository.findByEvent(eventType.getEvent());
                return event.orElseGet(() -> this.eventTypeRepository.saveAndFlush(eventType));
            }).toList();

            photographer.setEventTypes(events);

            Photographer photographerUploaded = this.photographerRepository.saveAndFlush(photographer);
            log.debug("photographerUploaded - ID : {} " , photographerUploaded.getId());
            isAllUpdated.set(photographerUploaded.getId() != null);
        });

        return isAllUpdated.get();
    }

    @Override
    public void clearAll() {
        this.photographerRepository.deleteAll();
    }

    @Override
    public List<Photographer> getAllPhotographers() {
        return this.photographerRepository.findAll();
    }

    @Override
    public List<Photographer> getAllPhotographersByEvent(List<String> eventTypes) {
        return this.photographerRepository.findByEventTypes_EventIn(eventTypes);
    }

    @Override
    public Optional<Photographer> getPhotographerById(Integer id) {
        return this.photographerRepository.findById(id);
    }


}
