package sample.spring.usemvc.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    public Jackson2HttpMessageConverter() {
        this(Jackson2ObjectMapperBuilder.json().build());
    }

    public Jackson2HttpMessageConverter(ObjectMapper objectMapper){
        super(
            objectMapper,
            new MediaType[]{
                MediaType.APPLICATION_JSON, 
                new MediaType("application", "**json")});
    }
}
