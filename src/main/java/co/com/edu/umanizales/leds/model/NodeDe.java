package co.com.edu.umanizales.leds.model;

import lombok.Data;

@Data
public class NodeDe {
    private Led data;
    private NodeDe next;
    private NodeDe previous;

    public NodeDe(Led data){this.data=data;}
}
