package com.microservices_app.userservice.modules.profile.service;

import com.microservices_app.userservice.modules.profile.entity.Profile;

public interface IProfileService {
    Profile getInfo(int id);
}
