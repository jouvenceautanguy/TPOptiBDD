package com.exo1.exo1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private UserDto organizer;
    private EventDetailDto eventDetail;
    private String name;
    private String type;
    private AddressDto address;
    private LocalDateTime dateTime;
    private Integer capacity;
    private Boolean isPaid;
    private BigDecimal price;
    private String description;
}
