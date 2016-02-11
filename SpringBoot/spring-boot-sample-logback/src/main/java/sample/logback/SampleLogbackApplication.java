package sample.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SampleLogbackApplication {

    private static final Logger logger = LoggerFactory
                .getLogger(SampleLogbackApplication.class);

    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleLogbackApplication.class, args);
    }
}
