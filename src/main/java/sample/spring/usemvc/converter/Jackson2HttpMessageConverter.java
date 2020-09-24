package sample.spring.usemvc.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

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
        System.out.println("★☆★" + MediaType.APPLICATION_JSON);
    }

    public void setNullToEmpty(boolean isNullToEmpty) {
        if(isNullToEmpty){
            DefaultSerializerProvider.Impl dsp = new DefaultSerializerProvider.Impl();
            dsp.setNullValueSerializer(new JsonSerializer<Object>() {
                @Override
                public void serialize(Object t, JsonGenerator jg, SerializerProvider sp)
                throws IOException, JsonProcessingException {
                    jg.writeString("");
                }
            });
            getObjectMapper().setSerializerProvider(dsp);
            System.out.println("★☆★ setNullToEmpty finish");
        }
    }
}
