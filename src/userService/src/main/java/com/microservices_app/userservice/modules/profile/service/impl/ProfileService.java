package com.microservices_app.userservice.modules.profile.service.impl;

import com.microservices_app.userservice.modules.profile.entity.Profile;
import com.microservices_app.userservice.modules.profile.mapper.IProfileMapper;
import com.microservices_app.userservice.modules.profile.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService implements IProfileService {
    @Autowired
    private IProfileMapper profileMapper;

    @Override
    public Profile getInfo(int id) {
        return profileMapper.getInfo(id);
    }
}
