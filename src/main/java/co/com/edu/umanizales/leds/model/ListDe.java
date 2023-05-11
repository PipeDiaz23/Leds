package co.com.edu.umanizales.leds.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
public class ListDe {
    private NodeDe head;
    private List<Led> leds;
    private int size;

    public void addLed(Led newLed) {
        NodeDe newNode = new NodeDe(newLed);

        if (head == null) {
            head = newNode;
        } else {
            NodeDe temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }//Parado en el ultimo

            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }
        size++;
    }

    public List<Led> getLeds() {
        leds = new ArrayList<>();
        NodeDe temp = head;
        leds.add(temp.getData());
        while (temp.getNext() != null) {
            temp = temp.getNext();
            leds.add(temp.getData());
        }
        return leds;
    }
    public void addToStart(Led newLed){
        NodeDe newNode = new NodeDe(newLed);
        if(head == null){
            head=newNode;
        }
        else{
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }

        size++;
        }

    public void turnOffOn() throws InterruptedException {
        NodeDe tempNext= head;
        NodeDe temPrev=head;
        if(size==1){
            temPrev.getData().setState(true);
            temPrev.getData().setDateOn(LocalDateTime.now());
            return;
        }
        for(int i=1; i< size/2;i++){
            temPrev=temPrev.getNext();
        }
        if (size%2==0){
            tempNext = temPrev.getNext();
        }
        else {
            temPrev=temPrev.getNext();
            tempNext=temPrev;
        }
        while (temPrev != null){
            temPrev.getData().setState(true);
            tempNext.getData().setState(true);
            temPrev.getData().setDateOn(LocalDateTime.now());
            tempNext.getData().setDateOn(LocalDateTime.now());
            if(temPrev.getPrevious()!=null) {
                TimeUnit.SECONDS.sleep(1);
                temPrev.getData().setState(false);
                tempNext.getData().setState(false);
                temPrev.getData().setDateOff(LocalDateTime.now());
                tempNext.getData().setDateOff(LocalDateTime.now());
                TimeUnit.SECONDS.sleep(1);
            }

            temPrev = temPrev.getPrevious();
            tempNext =tempNext.getNext();


        }

    }
}

