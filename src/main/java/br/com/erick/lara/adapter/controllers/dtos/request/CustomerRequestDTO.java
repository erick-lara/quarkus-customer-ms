package br.com.erick.lara.adapter.controllers.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;
}
