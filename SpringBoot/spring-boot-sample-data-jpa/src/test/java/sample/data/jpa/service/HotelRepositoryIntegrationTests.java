package sample.data.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.data.jpa.SampleDataJpaApplication;
import sample.data.jpa.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleDataJpaApplication.class)
public class HotelRepositoryIntegrationTests {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Test
    public void executesQueryMethodsCorrectly() {
        City city = this.cityRepository
                .findAll(new PageRequest(0, 1, Sort.Direction.ASC, "name")).getContent()
                .get(0);
        assertThat(city.getName()).isEqualTo("Atlanta");

        Page<HotelSummary> hotels = this.hotelRepository.findByCity(city,
                new PageRequest(0, 10, Sort.Direction.ASC, "name"));
        Hotel hotel = this.hotelRepository.findByCityAndName(city,
                hotels.getContent().get(0).getName());
        assertThat(hotel.getName()).isEqualTo("Doubletree");

        List<RatingCount> counts = this.hotelRepository.findRatingCounts(hotel);
        assertThat(counts).hasSize(1);
        assertThat(counts.get(0).getRating()).isEqualTo(Rating.AVERAGE);
        assertThat(counts.get(0).getCount()).isGreaterThan(1L);
    }

}
