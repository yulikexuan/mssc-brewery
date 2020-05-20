//: guru.springframework.msscbrewery.services.CustomerService.java


package guru.springframework.msscbrewery.services;


import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
public class CustomerService implements ICustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Stave Jobs")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("little_sami").build();
    }

    @Override
    public void update(UUID id, CustomerDto customer) {
        // TODO: Implement Customer Update
    }

    @Override
    public void delete(UUID id) {
        // TODO:0 Implement Customer Delete
    }

}///:~