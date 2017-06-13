package com.company.project.services;

import com.company.project.models.Event;
import com.company.project.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Event service implementation.
 */
@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setContactRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Iterable<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.delete(id);
    }

}
