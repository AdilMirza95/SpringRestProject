package az.developer.springrest1.rest.model.response;

import az.developer.springrest1.rest.model.request.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponse {
    private List<StudentDto> allStudents;

}
