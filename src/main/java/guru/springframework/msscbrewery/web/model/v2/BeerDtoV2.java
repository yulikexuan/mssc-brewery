//: guru.springframework.msscbrewery.web.model.v2.BeerDtoV2.java


package guru.springframework.msscbrewery.web.model.v2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BeerDtoV2 {

    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

}///:~