package sample.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sample.profile.service.MessageService;

@SpringBootApplication
public class SampleProfileApplication implements CommandLineRunner {

    @Autowired
    private MessageService messageService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(this.messageService.getMessage());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleProfileApplication.class, args);
    }
}
