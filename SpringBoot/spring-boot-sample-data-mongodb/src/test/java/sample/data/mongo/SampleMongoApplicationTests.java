package sample.data.mongo;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleMongoApplication.class)
@IntegrationTest
public class SampleMongoApplicationTests {

    @ClassRule
    public static OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        String output = SampleMongoApplicationTests.outputCapture.toString();
        assertThat(output).contains("firstName='Alice', lastName='Smith'");
    }
}
