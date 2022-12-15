package br.com.erick.lara.usecases.impl;

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

    public List<Customer> findAllCustomers(){
        return customerRepository
                .findAll()
                .list()
                .stream()
                .map(Customer::convertEntityToDomain)
                .collect(Collectors.toList());
    }
}
