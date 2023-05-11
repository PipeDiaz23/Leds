package co.com.edu.umanizales.leds.controller;

import co.com.edu.umanizales.leds.controller.dto.LedDTO;
import co.com.edu.umanizales.leds.controller.dto.ResponseDTO;
import co.com.edu.umanizales.leds.model.Led;
import co.com.edu.umanizales.leds.service.ListDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/leds")
public class ListDeController {
    @Autowired
    private ListDeService listDeService;

    @PostMapping(path ="/addled")
    public ResponseEntity<ResponseDTO> addLed(@RequestBody LedDTO ledDTO) {
        // Crear el objeto Led y agregarlo a la lista
        Led newLed = new Led(ledDTO.getId(), false, null, null);
        listDeService.getLeds().addLed(newLed);

        return new ResponseEntity<>(new ResponseDTO(200, "El bombillo se ha agregado", null),
                HttpStatus.OK);
    }
    @PostMapping(path ="/addledtostart")
    public ResponseEntity<ResponseDTO> addToStart(@RequestBody LedDTO ledDTO) {
        // Crear el objeto Led y agregarlo a la lista
        Led newLed = new Led(ledDTO.getId(), false, null, null);
        listDeService.getLeds().addToStart(newLed);

        return new ResponseEntity<>(new ResponseDTO(200, "El bombillo se ha agregado", null),
                HttpStatus.OK);
    }
    @GetMapping(path = "/getleds")
    public ResponseEntity<ResponseDTO> getleds(){
        return new ResponseEntity<>(new ResponseDTO(200, listDeService.getLeds().getLeds(), null),
                HttpStatus.OK);
    }
    @GetMapping(path = "/turnOnOff")
    public ResponseEntity<ResponseDTO> turnOffOn() throws InterruptedException{
        listDeService.getLeds().turnOffOn();return new ResponseEntity<>(new ResponseDTO
                (200, "Los leds se encencieron y se apagaron", null),
                HttpStatus.OK);

    }

}
