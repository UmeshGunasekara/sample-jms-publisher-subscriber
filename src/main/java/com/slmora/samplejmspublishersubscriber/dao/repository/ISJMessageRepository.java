/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:52 PM
 */
package com.slmora.samplejmspublishersubscriber.dao.repository;

import com.slmora.samplejmspublishersubscriber.entity.SJMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * This Interface created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:52 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          6/10/2021      SLMORA                Initial Code
 */
public interface ISJMessageRepository extends CrudRepository<SJMessage, Integer>
{
}
