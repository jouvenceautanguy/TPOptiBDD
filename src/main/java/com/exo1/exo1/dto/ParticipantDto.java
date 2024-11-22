package com.exo1.exo1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private UserDto user;
    private EventDto event;
    private String status;
    private Boolean paid;
    private BigDecimal rating;
    private String comment;
}
