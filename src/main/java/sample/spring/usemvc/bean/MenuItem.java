
package sample.spring.usemvc.bean;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "value",
    "onclick"
})

@Data
public class MenuItem {
    @JsonProperty
    private String value;

    @JsonProperty
    private String onclick;
    
}