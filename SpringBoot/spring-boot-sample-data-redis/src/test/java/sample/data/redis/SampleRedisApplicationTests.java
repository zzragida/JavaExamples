package sample.data.redis;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;
import org.springframework.data.redis.RedisConnectionFailureException;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleRedisApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        try {
            SampleRedisApplication.main(new String[0]);
        }
        catch (IllegalStateException ex) {
            if (!redisServerRunning(ex)) {
                return;
            }
        }
        String output = this.outputCapture.toString();
        assertThat(output).contains("Found key spring.boot.redis.test");
    }

    private boolean redisServerRunning(Throwable ex) {
        System.out.println(ex.getMessage());
        if (ex instanceof RedisConnectionFailureException) {
            return false;
        }
        return (ex.getCause() == null || redisServerRunning(ex.getCause()));
    }
}
