//: guru.springframework.msscbrewery.web.mapper.IBeerMapper.java


package guru.springframework.msscbrewery.web.mapper;


import guru.springframework.msscbrewery.domain.model.Beer;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.mapstruct.Mapper;


@Mapper(uses = DateTimeMapper.class)
public interface IBeerMapper {
    BeerDtoV2 beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDtoV2 beerDto);
}///:~