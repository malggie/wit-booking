package pl.sdacademy.booking.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NewEventDto {

    private String itemName;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;

}
