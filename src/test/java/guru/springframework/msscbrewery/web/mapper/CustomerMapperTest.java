//: guru.springframework.msscbrewery.web.mapper.CustomerMapperTest.java


package guru.springframework.msscbrewery.web.mapper;


import guru.springframework.msscbrewery.domain.model.Customer;
import guru.springframework.msscbrewery.services.ICustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Customer Mapstruct Mapper Test - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerMapperTest {

    private UUID id;
    private String name;

    @BeforeEach
    void setUp() {
        this.id = UUID.randomUUID();
        this.name = RandomStringUtils.randomAlphabetic(12);
    }

    @Test
    void test_Given_Customer_Then_Map_To_CustomerDto() {

        // Given
        Customer customer = Customer.builder()
                .id(this.id)
                .name(this.name)
                .build();

        // When
        CustomerDto dto = ICustomerMapper.INSTANCE.customerToCustomerDto(
                customer);

        // Then
        assertThat(dto.getId()).isEqualTo(this.id);
        assertThat(dto.getName()).isEqualTo(this.name);
    }

    @Test
    void test_Given_CustomerDto_Then_Map_To_Customer() {

        // Given
        CustomerDto dto = CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .build();

        // When
        Customer customer = ICustomerMapper.INSTANCE.customerDtoToCustomer(dto);

        // Then
        assertThat(dto.getId()).isEqualTo(this.id);
        assertThat(dto.getName()).isEqualTo(this.name);
    }

}///:~