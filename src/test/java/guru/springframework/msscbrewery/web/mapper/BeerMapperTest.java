//: guru.springframework.msscbrewery.web.mapper.BeerMapperTest.java


package guru.springframework.msscbrewery.web.mapper;


import guru.springframework.msscbrewery.domain.model.Beer;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@DisplayName("Beer Mapstruct Mapper Test - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BeerMapperTest {

    private UUID id;
    private String name;

    @Autowired
    IBeerMapper beerMapper;

    @BeforeEach
    void setUp() {
        this.id = UUID.randomUUID();
        this.name = RandomStringUtils.randomAlphabetic(12);
    }

    @Test
    void test_Given_Beer_Then_Map_To_BeerDto() {

        // Given
        Beer beer = Beer.builder()
                .id(id)
                .beerName(this.name)
                .beerStyle(BeerStyleEnum.STOUT)
                .upc(10L)
                .createdDate(Timestamp.from(Instant.now()))
                .lastUpdatedDate(Timestamp.from(Instant.now()))
                .build();

        // When
        guru.springframework.msscbrewery.web.model.v2.BeerDtoV2 dto =
                beerMapper.beerToBeerDto(beer);

        // Then
        assertThat(dto).isNotNull();

    }

}///:~