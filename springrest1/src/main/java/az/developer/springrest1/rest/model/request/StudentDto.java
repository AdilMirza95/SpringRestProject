package az.developer.springrest1.rest.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private int id;
    private String name;
    private String surname;
    private int age;
}
