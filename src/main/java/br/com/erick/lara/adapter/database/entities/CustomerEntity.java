package br.com.erick.lara.adapter.database.entities;

import br.com.erick.lara.adapter.controllers.dtos.request.CustomerRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

    public void populate(CustomerRequestDTO requestDTO){
        this.name = requestDTO.getName();
        this.phone = requestDTO.getPhone();
        this.address = requestDTO.getAddress();
        this.email = requestDTO.getEmail();
        this.age = requestDTO.getAge();
    }
}
