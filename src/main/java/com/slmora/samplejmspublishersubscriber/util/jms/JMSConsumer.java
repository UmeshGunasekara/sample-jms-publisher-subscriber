/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:00 PM
 */
package com.slmora.samplejmspublishersubscriber.util.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:00 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@Component
public class JMSConsumer
{
    private static final Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination="${activemq.test.topic}",containerFactory = "topicBasedConnectionFactory")
    @Async
    public void receiveVTopicB(String message) throws JMSException
    {
        logger.debug("Test Topic1 Message : "+ message);
        System.out.println("Test Topic1 Message : "+ message);

        try{
            Thread.sleep(500L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
