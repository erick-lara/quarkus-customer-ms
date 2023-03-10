package br.com.erick.lara.usecases.impl;

import br.com.erick.lara.adapter.controllers.dtos.request.CustomerRequestDTO;
import br.com.erick.lara.adapter.database.entities.CustomerEntity;
import br.com.erick.lara.adapter.database.repositories.CustomerRepository;
import br.com.erick.lara.domain.Customer;
import br.com.erick.lara.usecases.CustomerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DefaultCustomerService implements CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers(){
        return customerRepository
                .findAll()
                .list()
                .stream()
                .map(Customer::convertEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void createNewCustomer(CustomerRequestDTO customerRequestDTO) {
        CustomerEntity entity = customerRequestDTO.convertDtoToEntity();
        customerRepository.persist(entity);
    }

    @Override
    public void updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = customerRepository.findById(id);
        customer.populate(customerRequestDTO);
        customerRepository.persist(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
