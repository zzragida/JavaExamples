package sample.tomcat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.tomcat.service.HelloWorldService;

@Controller
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return this.helloWorldService.getHelloMessage();
    }
}
