package com.example.mobilelele.DTO;

import java.util.ArrayList;
import java.util.List;

public class ShowBrandDTO {


    private String name;
    private List<ShowModelDTO> models;

    public ShowBrandDTO() {
        this.models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShowModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ShowModelDTO> models) {
        this.models = models;
    }


}

