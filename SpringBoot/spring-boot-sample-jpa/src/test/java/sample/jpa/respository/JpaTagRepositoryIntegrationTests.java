package sample.jpa.respository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.jpa.SampleJpaApplication;
import sample.jpa.domain.Tag;
import sample.jpa.repository.JpaTagRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleJpaApplication.class)
public class JpaTagRepositoryIntegrationTests {

    @Autowired
    JpaTagRepository repository;

    @Test
    public void findsAllTags() {
        List<Tag> tags = this.repository.findAll();
        assertThat(tags).hasSize(3);
    }
}
