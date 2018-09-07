package com.andreitop.newco.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto implements DTO {

    @JsonIgnore
    private static final long serialVersionUID = 5914366185889783660L;

    @NotNull
    @Min(0L)
    private Long id;

    @NotEmpty
    @Pattern(regexp = "[A-Z]{1,3}")
    private String origin;

    @NotEmpty
    @Pattern(regexp = "[A-Z]{1,3}")
    private String destination;

    @NotNull
    @Positive
    @Min(100)
    @Max(100000)
    private Integer price;
}