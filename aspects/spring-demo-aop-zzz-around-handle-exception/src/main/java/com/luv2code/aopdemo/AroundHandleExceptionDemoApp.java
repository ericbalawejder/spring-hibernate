package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AroundHandleExceptionDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        myLogger.info("\nMy fortune is: " + data);

        myLogger.info("Finished");

        // close the context
        context.close();
    }
}
