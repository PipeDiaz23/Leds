package co.com.edu.umanizales.leds.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private int id;
    private boolean state;
    private LocalDateTime dateOn;
    private LocalDateTime dateOff;
}
