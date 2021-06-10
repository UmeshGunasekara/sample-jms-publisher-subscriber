/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:28 PM
 */
package com.slmora.samplejmspublishersubscriber.service;

import com.slmora.samplejmspublishersubscriber.entity.SJMessage;
import com.slmora.samplejmspublishersubscriber.payload.request.PublishMessageRequest;
import com.slmora.samplejmspublishersubscriber.payload.vo.MessageVo;

import java.util.List;

/**
 * This Interface created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:28 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
public interface ISJMessageService
{
    public SJMessage save(PublishMessageRequest messageRequest);
    public SJMessage save(String message, String type, String destination, String status);
    public List<MessageVo> getAllMessages();
}
