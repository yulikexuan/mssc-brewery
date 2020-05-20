//: guru.springframework.msscbrewery.services.IBeerService.java


package guru.springframework.msscbrewery.services;


import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;


public interface IBeerService {

    BeerDto getBeerById(UUID beerId);
    BeerDto save(BeerDto beer);

    void update(UUID id, BeerDto beer);
    void delete(UUID id);

}///:~