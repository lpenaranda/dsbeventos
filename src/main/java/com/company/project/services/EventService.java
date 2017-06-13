package com.company.project.services;

import com.company.project.models.Event;

public interface EventService {

    Iterable<Event> listAllEvents();

    Event getEventById(Integer id);

    Event saveEvent(Event event);

    void deleteEvent(Integer id);

}
