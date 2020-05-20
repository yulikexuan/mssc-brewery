//: guru.springframework.msscbrewery.web.controller.BeerController.java


package guru.springframework.msscbrewery.web.controller;


import guru.springframework.msscbrewery.services.IBeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final IBeerService beerService;

    @Autowired
    public BeerController(IBeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BeerDto beer) {

        log.info(">>>>>>> Creating a new beer: {}", beer.toString());

        BeerDto savedBeer = this.beerService.save(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", buildUrl("/api/v1/beer",
                savedBeer.getId().toString()));

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(
            @PathVariable("beerId") UUID beerId,
            @RequestBody BeerDto beer) {

        log.info(">>>>>>> Updating a existing beer: {}", beer.toString());
        this.beerService.update(beerId, beer);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID id) {
        this.beerService.delete(id);
    }

    private String buildUrl(String uri, String pathVariable) {
        // TODO: Add host name to URI parameter
        return String.join("/", uri, pathVariable);
    }

}///:~