package com.example.learnjms.firstjms;

import org.springframework.jms.annotation.JmsListener;

import org.springframework.stereotype.Component;

@Component
public class JmsMessageReceiver {
    @JmsListener( destination = "queue-name",containerFactory ="warehouse")
    public void receiveMessage (String message)
    {
   System.out.println("Message Received"+ message);
    }
}
