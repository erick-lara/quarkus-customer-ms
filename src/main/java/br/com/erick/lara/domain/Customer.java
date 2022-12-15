package br.com.erick.lara.domain;

import br.com.erick.lara.adapter.database.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

    public static Customer convertEntityToDomain(CustomerEntity entity){
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getAge()
        );
    }
}
