package com.burdennn.springframework.context.event;

import com.burdennn.springframework.context.ApplicationEvent;
import com.burdennn.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void remoteApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
