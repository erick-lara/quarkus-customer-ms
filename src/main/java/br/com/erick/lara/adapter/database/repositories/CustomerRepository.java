package br.com.erick.lara.adapter.database.repositories;

import br.com.erick.lara.adapter.database.entities.CustomerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface CustomerRepository extends PanacheRepository<CustomerEntity> {
}
