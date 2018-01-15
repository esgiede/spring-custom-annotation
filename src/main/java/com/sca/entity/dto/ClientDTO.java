package com.sca.entity.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@Builder
public class ClientDTO {

    private String name;
    private String lastName;
    private String address;
    @Size(min = 9, max = 12)
    private String phone;

}
