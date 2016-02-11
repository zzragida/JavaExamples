package sample.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

@EnableAutoConfiguration
@ComponentScan
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SampleSecureApplication implements CommandLineRunner {

    @Autowired
    private SampleService service;

    @Override
    public void run(String... strings) throws Exception {
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken("user", "N/A",
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
        try {
            System.out.println(this.service.secure());
        }
        finally {
            SecurityContextHolder.clearContext();
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleSecureApplication.class, "--debug");
    }
}
