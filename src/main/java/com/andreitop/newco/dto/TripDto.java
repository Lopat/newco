package com.andreitop.newco.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TripDto implements DTO {

    @JsonIgnore
    private static final long serialVersionUID = 5914366185889783660L;
    private Long id;
    private String origin;
    private String destination;
    private Integer price;
}