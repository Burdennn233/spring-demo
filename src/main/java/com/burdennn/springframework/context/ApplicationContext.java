package com.burdennn.springframework.context;

import com.burdennn.springframework.beans.factory.HierarchicalBeanFactory;
import com.burdennn.springframework.beans.factory.ListableBeanFactory;
import com.burdennn.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
