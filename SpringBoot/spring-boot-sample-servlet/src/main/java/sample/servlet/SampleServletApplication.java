package sample.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
@EnableAutoConfiguration
public class SampleServletApplication extends SpringBootServletInitializer {

    @SuppressWarnings("serial")
    @Bean
    public Servlet dispatcherServlet() {
        return new GenericServlet() {
            @Override
            public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
                res.setContentType("text/plain");
                res.getWriter().append("Hello World");
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleServletApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleServletApplication.class, args);
    }
}
