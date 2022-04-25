package com.burdennn.springframework.context.event;

import com.burdennn.springframework.context.ApplicationEvent;

public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
