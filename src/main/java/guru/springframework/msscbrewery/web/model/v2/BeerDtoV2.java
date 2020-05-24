//: guru.springframework.msscbrewery.web.model.v2.BeerDtoV2.java


package guru.springframework.msscbrewery.web.model.v2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BeerDtoV2 {

    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

    /*
     * OffsetDateTime is a thread-safe class that stores date and time to a
     * precision of nanoseconds
     *
     * Date, on the other hand, is not thread-safe and stores time to
     * millisecond precision
     *
     * OffsetDateTime is a value-based class, which means that we need to use
     * equals when comparing references instead of the typical ==
     *
     * The output of OffsetDateTime‘s toString method is in ISO-8601 format,
     * while Date‘s toString is in a custom non-standard format
     *
     * Date can't store timezones and corresponding offsets
     *
     * The only thing that a Date object contains is the number of milliseconds
     * since 1 January 1970, 00:00:00 UTC, so if our time isn't in UTC,
     * we should store the timezone in a helper class
     *
     * On the contrary, OffsetDateTime stores the ZoneOffset internally
     *
     */
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;

}///:~