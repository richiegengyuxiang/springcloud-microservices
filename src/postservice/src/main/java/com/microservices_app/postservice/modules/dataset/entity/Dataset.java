package com.microservices_app.postservice.modules.dataset.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Dataset {

    private String id;
    private String name;
    private String description;
    private String type;
    private String repoId;
}
