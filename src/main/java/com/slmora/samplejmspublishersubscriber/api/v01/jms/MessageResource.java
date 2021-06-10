/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:40 PM
 */
package com.slmora.samplejmspublishersubscriber.api.v01.jms;

import com.slmora.samplejmspublishersubscriber.payload.vo.MessageVo;
import com.slmora.samplejmspublishersubscriber.service.ISJMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:40 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@RestController
@RequestMapping("/api/v01")
public class MessageResource
{

    @Autowired
    private ISJMessageService messageService;

    @GetMapping("/messages")
    public List<MessageVo> getMessages(){
        return messageService.getAllMessages();
    }
}
