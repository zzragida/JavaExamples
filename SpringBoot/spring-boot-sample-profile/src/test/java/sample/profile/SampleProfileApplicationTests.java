package sample.profile;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertTrue;

public class SampleProfileApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private String profiles;

    @Before
    public void before() {
        this.profiles = System.getProperty("spring.profiles.active");
    }

    @After
    public void after() {
        if (this.profiles != null) {
            System.setProperty("spring.profiles.active", this.profiles);
        }
        else {
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    public void testDefaultProfile() throws Exception {
        SampleProfileApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Hello Phil"));
    }

    @Test
    public void testGoodbyeProfile() throws Exception {
        System.setProperty("spring.profiles.active", "goodbye");
        SampleProfileApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Goodbye Everyone"));
    }

    @Test
    public void testGenericProfile() throws Exception {
        System.setProperty("spring.profiles.active", "generic");
        SampleProfileApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Bonjour Phil"));
    }

    @Test
    public void testGoodbyeProfileFromCommandline() throws Exception {
        SampleProfileApplication.main(new String[] {"--spring.profiles.active=goodbye"});
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Goodbye Everyone"));
    }
}
