package az.developer.springrest1.service;

import az.developer.springrest1.rest.model.request.StudentDto;
import az.developer.springrest1.rest.model.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse getAllStudents();
    StudentDto getStudentById(int id);
    StudentResponse getStudentByName(String name);
    void insert(StudentDto sDto);
    void updatePut(int id,StudentDto sDto);
    void updatePath(int id,StudentDto sDto);
}
