/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:05 PM
 */
package com.slmora.samplejmspublishersubscriber.api.v01.jms;

import com.slmora.samplejmspublishersubscriber.payload.request.PublishMessageRequest;
import com.slmora.samplejmspublishersubscriber.payload.response.MessageResponse;
import com.slmora.samplejmspublishersubscriber.service.ISJMessageService;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:05 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@RestController
@RequestMapping("/api/v01/msg")
public class MessagePublisher
{
    private static final Logger logger = LoggerFactory.getLogger(MessagePublisher.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ISJMessageService messageService;

    @PostMapping("/publish")
    public ResponseEntity<?> signUpUser(@Valid
                                            @RequestBody
                                                PublishMessageRequest messageRequest){
        try {
            ActiveMQTopic topic = new ActiveMQTopic(messageRequest.getTopic());
            jmsMessagingTemplate.convertAndSend(topic, messageRequest.getMessage());
            messageService.save(messageRequest);
            return ResponseEntity.ok(new MessageResponse("Message Sent successfully!"));
//        }catch (MessagingException | JpaSystemException ex){
        }catch (MessagingException ex){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error Happened, Message Not sent"));
        }
    }
}
