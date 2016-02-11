package sample.data.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.data.jpa.SampleDataJpaApplication;
import sample.data.jpa.domain.City;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleDataJpaApplication.class)
public class CityRepositoryIntegrationTests {

    @Autowired
    CityRepository repository;

    @Test
    public void findsFirstPageOfCities() {
        Page<City> cities = this.repository.findAll(new PageRequest(0, 10));
        assertThat(cities.getTotalElements()).isGreaterThan(20L);
    }

}
