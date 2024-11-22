package com.exo1.exo1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private EventDto event;
    private String key;
    private String value;
}
