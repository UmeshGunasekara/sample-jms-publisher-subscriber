/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:52 PM
 */
package com.slmora.samplejmspublishersubscriber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:52 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sj_message")
public class SJMessage implements Serializable
{
    private static final long serialVersionUID = -7828705894115051172L;

    @Id
    @Basic(optional = false)
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer messageId;

    @Column(name = "message", length = 250)
    private String message;

    @Basic(optional = false)
    @Column(name = "message_type", length = 20)
    private String messageType;

    @Basic(optional = false)
    @Column(name = "message_status", length = 100)
    private String messageStatus;

    @Column(name = "jms_destination", length = 20)
    private String jmsDestination;

    @Basic(optional = false)
    @Column(name = "update_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateTime;

    @Basic(optional = false)
    @Column(name = "create_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;

    public SJMessage(String message, String messageType, String messageStatus, String jmsDestination){
        this.message = message;
        this.messageType = messageType;
        this.messageStatus = messageStatus;
        this.jmsDestination = jmsDestination;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SJMessage sjMessage = (SJMessage) o;

        return messageId != null ? messageId.equals(sjMessage.messageId) : sjMessage.messageId == null;
    }

    @Override
    public int hashCode()
    {
        return messageId != null ? messageId.hashCode() : 0;
    }
}
