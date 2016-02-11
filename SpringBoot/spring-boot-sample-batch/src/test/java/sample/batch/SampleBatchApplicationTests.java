package sample.batch;


import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleBatchApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(SpringApplication.exit(SpringApplication.run(SampleBatchApplication.class))).isEqualTo(0);
        String output = this.outputCapture.toString();
        assertThat(output).contains("completed with the following parameters");
    }
}
