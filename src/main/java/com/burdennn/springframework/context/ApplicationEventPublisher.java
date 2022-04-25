package com.burdennn.springframework.context;

public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
