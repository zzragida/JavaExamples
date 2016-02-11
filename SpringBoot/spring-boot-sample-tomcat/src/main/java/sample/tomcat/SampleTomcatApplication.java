package sample.tomcat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication
public class SampleTomcatApplication {

    private static Log logger = LogFactory.getLog(SampleTomcatApplication.class);

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent servletContextEvent) {
                logger.info("ServletContext initialize");
            }

            @Override
            public void contextDestroyed(ServletContextEvent servletContextEvent) {
                logger.info("ServletContext destoryed");
            }
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleTomcatApplication.class, args);
    }
}
