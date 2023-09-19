package pl.sdacademy.booking.service;

import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.model.EventDto;
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
}
