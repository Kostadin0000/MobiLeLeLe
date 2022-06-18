package com.example.mobilelele.DTO;

import com.example.mobilelele.enums.EngineEnum;
import com.example.mobilelele.enums.TransmissionEnum;
import com.example.mobilelele.validation.YearInPastOrPresent;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;

public class AddOfferDTO {
    @NotEmpty
    @Size(min = 10, max = 500)
    private String description;

    @NotEmpty
    private String engine;

    @NotEmpty
    private String imageUrl;

    @NotNull
    @Positive
    private Integer mileage;

    @NotNull
    @Min(100)
    private BigDecimal price;

    @NotEmpty
    private String transmission;

    @YearInPastOrPresent(minYear = 1930)
    private Integer year;

    @NotNull
    private long modelId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "AddOfferDTO{" +
                "description='" + description + '\'' +
                ", engine='" + engine + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission='" + transmission + '\'' +
                ", year=" + year +
                ", modelId=" + modelId +
                '}';
    }
}
