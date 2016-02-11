package sample.data.rest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.data.rest.SampleDataRestApplication;
import sample.data.rest.domain.City;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleDataRestApplication.class)
public class CityRepositoryIntegrationTests {

    @Autowired
    CityRepository repository;

    @Test
    public void findsFirstPageOfCities() {
        Page<City> cities = this.repository.findAll(new PageRequest(0, 10));
        assertThat(cities.getTotalElements()).isGreaterThan(20L);
    }

    @Test
    public void findByNameAndCountry() {
        City city = this.repository.findByNameAndCountryAllIgnoringCase("Melbourne", "Australia");
        assertThat(city).isNotNull();
        assertThat(city.getName()).isEqualTo("Melbourne");
    }

    @Test
    public void findContaining() {
        Page<City> cities = this.repository
                .findByNameContainingAndCountryContainingAllIgnoringCase("", "UK",
                            new PageRequest(0, 10));
        assertThat(cities.getTotalElements()).isEqualTo(3L);
    }
}
