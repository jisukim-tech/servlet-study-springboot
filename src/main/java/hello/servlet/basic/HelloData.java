package hello.servlet.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloData {
    @JsonProperty("username")
    private String userName;
    private int age;
}
