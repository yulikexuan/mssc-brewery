//: guru.springframework.msscbrewery.services.BeerService.java


package guru.springframework.msscbrewery.services;


import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
public class BeerService implements IBeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto save(BeerDto beer) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("QingDao").build();
    }

    @Override
    public void update(UUID id, BeerDto beer) {
        // TODO: Implement Beer Update
        log.info("Update beer by id: {}", id);
    }

    @Override
    public void delete(UUID id) {
        // TODO: Implement Beer Delete
        log.info("Delete beer by id: {}", id);
    }

}///:~