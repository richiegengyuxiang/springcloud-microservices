package com.microservices_app.userservice.modules.profile.controller;

import com.microservices_app.userservice.modules.profile.service.impl.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/")
    public String foo(){

        final String uri = "http://localhost:5000";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    public String getInfo(){
        return profileService.getInfo(1).toString();
    }
}

