package com.burdennn.springframework.event;

import com.burdennn.springframework.context.ApplicationListener;

import java.util.Date;

public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Get :" + event.getSource() + " at time " + new Date());
        System.out.println("Message " + event.getId() + ": " + event.getMessage());
    }
}
