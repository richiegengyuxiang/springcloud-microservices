package com.microservices_app.userservice.modules.profile.mapper;

import com.microservices_app.userservice.modules.profile.entity.Profile;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileMapper {
    
    Profile getInfo(int id);
}