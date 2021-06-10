/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:29 PM
 */
package com.slmora.samplejmspublishersubscriber.service.impl;

import com.slmora.samplejmspublishersubscriber.dao.repository.ISJMessageRepository;
import com.slmora.samplejmspublishersubscriber.entity.SJMessage;
import com.slmora.samplejmspublishersubscriber.payload.request.PublishMessageRequest;
import com.slmora.samplejmspublishersubscriber.payload.vo.MessageVo;
import com.slmora.samplejmspublishersubscriber.service.ISJMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:29 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@Service
@Transactional
public class SJMessageServiceImpl implements ISJMessageService
{

    private final ModelMapper modelMapper;
    private final ISJMessageRepository messageRepository;

    @Autowired
    public SJMessageServiceImpl(ModelMapper modelMapper,
                                ISJMessageRepository messageRepository)
    {
        this.modelMapper = modelMapper;
        this.messageRepository = messageRepository;
    }

    @Override
    public SJMessage save(PublishMessageRequest messageRequest)
    {
        SJMessage message = new SJMessage(
                messageRequest.getMessage(),
                "Topic",
                "Sent",
                messageRequest.getTopic()
        );
        message.setCreateDateTime(new Date(System.currentTimeMillis()));
        message.setUpdateDateTime(new Date(System.currentTimeMillis()));
        return messageRepository.save(message);
    }

    @Override
    public SJMessage save(String message, String type, String destination, String status)
    {
        SJMessage msg = new SJMessage(
                message,
                type,
                status,
                destination
        );
        msg.setCreateDateTime(new Date(System.currentTimeMillis()));
        msg.setUpdateDateTime(new Date(System.currentTimeMillis()));
        return messageRepository.save(msg);
    }

    @Override
    public List<MessageVo> getAllMessages()
    {
        return StreamSupport.stream(messageRepository.findAll().spliterator(),false)
                .map(user -> modelMapper.map(user, MessageVo.class))
                .collect(Collectors.toList());
    }
}
