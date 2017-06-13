package com.company.project.controllers;

import com.company.project.models.Event;
import com.company.project.services.EventService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Event controller.
 */
@Controller
public class EventController {

    private EventService eventService;
    
    final static Logger logger = LoggerFactory.getLogger("MYAPP");

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * List all events.
     *
     * @param model
     * @return1111
     */
    @RequestMapping(value = "/eventos", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("events", eventService.listAllEvents());
        logger.info("Returning event list.");
        return "events";
    }    
    
    /**
     * View a specific event by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("eventos/{id}")
    public String showEvent(@PathVariable Integer id, Model model) {
    	Event event = eventService.getEventById(id);
    	if(event != null) {
    		logger.info("Showing event id: "+event.getId().toString());
    		model.addAttribute("event", event);
        	return "eventshow";
    	}else{
    		return "redirect:/eventos";
    	}   	
    }

    // Afficher le formulaire de modification du Event
    @RequestMapping("eventos/{id}/editar")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "eventform";
    }

    /**
     * New event.
     *
     * @param model
     * @return
     */
    @RequestMapping("eventos/nuevo")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        return "eventform";
    }

    /**
     * Save event to database.
     *
     * @param event
     * @return
     */
    @RequestMapping(value = "eventos", method = RequestMethod.POST)
    public String saveEvent(Event event) {
        eventService.saveEvent(event);
        return "redirect:/eventos/" + event.getId();
    }

    /**
     * Delete event by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("eventos/{id}/eliminar")
    public String delete(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return "redirect:/eventos";
    }

}
