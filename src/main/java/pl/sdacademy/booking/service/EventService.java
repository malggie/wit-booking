package pl.sdacademy.booking.service;

import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.model.EventDto;
import pl.sdacademy.booking.model.NewEventDto;
import pl.sdacademy.booking.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    List<EventDto> findAll() {
        List<EventDto> result = new ArrayList<>();
        List<EventEntity> events = eventRepository.findAll();
        for (EventEntity event : events) {
            result.add(EventDto.builder()
                    .name(event.getItem().getName())
                    .price(event.getItem().getPrice())
                    .fromTime(event.getFrom())
                    .toTime(event.getTo())
                    .build());
        }
        return result;
    }


//    public String addEvent(NewEventDto newEvent) {
//        Long eventsByName = eventRepository.findEventsByDate(newEvent.getFromTime());
//        if (eventsByName != null) {
//            return "Sesja już istnieje.";
//        }
//        EventEntity eventEntity = new EventEntity();
//
//        //tutaj bedzie wyszukiwanie id_itemu po jego nazwie - być może można wykorzystać metode repostitory Item findbyName
//        //eventEntity.setItem(itemId)
//        eventEntity.setFrom(newEvent.getFromTime());
//        eventEntity.setTo(newEvent.getToTime());
//        eventRepository.addEvent(eventEntity);
//        return "Sesja została zapisana";
//    }

}
