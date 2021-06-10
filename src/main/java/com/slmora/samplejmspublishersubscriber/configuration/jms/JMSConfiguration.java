/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:57 PM
 */
package com.slmora.samplejmspublishersubscriber.configuration.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.jms.ConnectionFactory;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:57 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@Configuration
@EnableJms
@EnableAsync
public class JMSConfiguration
{
    private static final Logger logger = LoggerFactory.getLogger(JMSConfiguration.class);

    @Value("${activemq.url}")
    private String url;
    @Value("${activemq.username}")
    private String username;
    @Value("${activemq.password}")
    private String password;
    @Value("${activemq.clientid}")
    private String clientId;

    @Bean(name="jmsConnectionFactory")
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(url);
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean(name="topicBasedConnectionFactory")
    public JmsListenerContainerFactory<?> jmsTopicListenerContainerFactory(
            @Qualifier("jmsConnectionFactory")
                    ConnectionFactory connectionFactory)
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setClientId(clientId);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean(name="queueBasedConnectionFactory")
    public JmsListenerContainerFactory<?> jmsQueueListenerContainerFactory(
            @Qualifier("jmsConnectionFactory")ConnectionFactory connectionFactory)
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter()
    {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
