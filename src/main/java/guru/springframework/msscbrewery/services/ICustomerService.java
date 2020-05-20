//: guru.springframework.msscbrewery.services.ICustomerService.java


package guru.springframework.msscbrewery.services;


import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;


public interface ICustomerService {

    CustomerDto getCustomerById(UUID customerId);
    CustomerDto save(CustomerDto customer);

    void update(UUID id, CustomerDto customer);
    void delete(UUID id);

}///:~