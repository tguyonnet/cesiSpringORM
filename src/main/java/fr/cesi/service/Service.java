package fr.cesi.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {
    private ClassPathXmlApplicationContext context;

    public ClassPathXmlApplicationContext getContext() {
        if (this.context == null) {
            this.context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        }
        return this.context;
    }

}
