package sample.spring.usemvc.controller;

import org.springframework.web.bind.annotation.RestController;

import sample.spring.usemvc.bean.MenuItem;
import sample.spring.usemvc.converter.Jackson2HttpMessageConverter;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class JsonController {
    
    @RequestMapping("/test")
    public MenuItem test(){
        MenuItem item = new MenuItem();
        item.setOnclick("onclick");
        item.setValue(null);
        return item;
    }
}
