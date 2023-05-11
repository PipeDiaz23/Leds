package co.com.edu.umanizales.leds.service;

import co.com.edu.umanizales.leds.model.ListDe;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDeService {
private ListDe leds;
public ListDeService(){leds = new ListDe();}
}
