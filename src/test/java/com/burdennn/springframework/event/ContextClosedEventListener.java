package com.burdennn.springframework.event;

import com.burdennn.springframework.context.ApplicationListener;
import com.burdennn.springframework.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Close context event:" + event.getSource());
    }
}
