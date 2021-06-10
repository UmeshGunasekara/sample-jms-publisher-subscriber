/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/30/2021 1:28 PM
 */
package com.slmora.samplejmspublishersubscriber.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 6/10/2021 5:00 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          5/30/2021      SLMORA                Initial Code
 */
@RestController
public class WelcomeController
{

    @Value("${app-title}")
    private String projectTitle;

    @GetMapping("/")
    public String wellcome()
    {
        return "Wellcome "+projectTitle;
    }
}
