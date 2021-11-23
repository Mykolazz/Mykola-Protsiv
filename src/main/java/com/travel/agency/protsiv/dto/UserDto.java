package com.travel.agency.protsiv.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String login;
    private String name;
    private String email;
    private Integer age;
}
