//: guru.springframework.msscbrewery.web.mapper.ICustomerMapper.java


package guru.springframework.msscbrewery.web.mapper;


import guru.springframework.msscbrewery.domain.model.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ICustomerMapper {

    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);

}///:~