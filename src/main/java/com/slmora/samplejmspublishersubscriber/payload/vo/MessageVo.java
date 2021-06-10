/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:41 PM
 */
package com.slmora.samplejmspublishersubscriber.payload.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 6:41 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageVo
{
    private Integer messageId;
    private String message;
    private String messageType;
    private String messageStatus;
    private String jmsDestination;
    private Date createDateTime;
}
