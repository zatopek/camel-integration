package org.gautam.backbase.receivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "google.geocode", containerFactory = "defaultFactory")
    public void receiveMessage(String address) {
        System.out.println("Received <" + address + ">");
    }

}