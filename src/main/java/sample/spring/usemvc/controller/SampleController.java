package sample.spring.usemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello world!
 *
 */
@Controller
public class SampleController {

    @RequestMapping("/")
    public String sample() {
        return "sample";
    }
}
