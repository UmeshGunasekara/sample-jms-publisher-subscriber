package com.slmora.samplejmspublishersubscriber;

import com.slmora.samplejmspublishersubscriber.dao.repository.ISJMessageRepository;
import com.slmora.samplejmspublishersubscriber.entity.SJMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SampleJmsPublisherSubscriberApplication
{
    @Autowired
    private ISJMessageRepository messageRepository;

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SampleJmsPublisherSubscriberApplication.class, args);
    }

    @PostConstruct
    public void initMessage() {
        SJMessage msg = new SJMessage(1, "Init Message", "Test", "Test", "Test", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        messageRepository.save(msg);
    }

}
