package br.com.erick.lara.usecases;

import br.com.erick.lara.adapter.controllers.dtos.request.CustomerRequestDTO;
import br.com.erick.lara.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    void createNewCustomer(CustomerRequestDTO customerRequestDTO);
    void updateCustomer(Long id, CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(Long id);
}
