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
    private CustomerRepository customerRepository;

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
        customerRepository.persist(customerRequestDTO.convertDtoToEntity());
    }

    @Override
    public void updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.convertEntityToDomain(customerRepository.findById(id));
        customer.populate(customerRequestDTO);
        customerRepository.persist(customer.convertDomainToEntity());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
