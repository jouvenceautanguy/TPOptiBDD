package com.exo1.exo1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String email;
    private String username;
    private String password;
    private AddressDto address;
    private Integer age;
    private String interests;
    private BigDecimal rating;
}
