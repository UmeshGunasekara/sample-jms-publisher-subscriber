package com.slmora.samplejmspublishersubscriber;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleJmsPublisherSubscriberApplication
{

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SampleJmsPublisherSubscriberApplication.class, args);
    }

}
