package br.com.erick.lara.adapter.controllers.dtos.request;

import br.com.erick.lara.adapter.database.entities.CustomerEntity;
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

    public CustomerEntity convertDtoToEntity(){
        return new CustomerEntity(
                0L,
                this.name,
                this.phone,
                this.email,
                this.address,
                this.age
        );
    }
}
