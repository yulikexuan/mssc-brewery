//: guru.springframework.msscbrewery.domain.model.Customer.java


package guru.springframework.msscbrewery.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Customer {
    private UUID id;
    private String name;
}///:~