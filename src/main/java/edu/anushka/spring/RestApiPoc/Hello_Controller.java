package edu.anushka.spring.RestApiPoc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
