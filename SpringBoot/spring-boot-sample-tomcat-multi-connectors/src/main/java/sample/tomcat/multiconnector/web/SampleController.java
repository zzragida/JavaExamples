package sample.tomcat.multiconnector.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
}
