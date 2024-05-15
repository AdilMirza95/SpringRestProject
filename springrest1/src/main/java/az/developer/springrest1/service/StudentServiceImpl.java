package az.developer.springrest1.service;

import az.developer.springrest1.model.Student;
import az.developer.springrest1.repository.StudentRepository;
import az.developer.springrest1.rest.model.request.StudentDto;
import az.developer.springrest1.rest.model.response.StudentResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public StudentResponse getAllStudents() {
        List<Student> slist = studentRepository.findAll();
        List<StudentDto> dtolist = new ArrayList<>();

        for (Student s: slist){
            dtolist.add(convertDto(s));
        }
        return new StudentResponse(dtolist);
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student s = studentRepository.findById(id).orElseThrow();
        return convertDto(s);
    }

    @Override
    public StudentResponse getStudentByName(String name) {
        List<Student> slist =  studentRepository.findStudentByName(name);
        List<StudentDto> dtolist = new ArrayList<>();

        for (Student s: slist){
            dtolist.add(convertDto(s));
        }
        return new StudentResponse(dtolist);
    }

    @Override
    public void insert(StudentDto sDto) {

        studentRepository.save(convertEntity(sDto));
    }

    @Override
    public void updatePut(int id,StudentDto sDto) {
        Student s = studentRepository.findById(id).orElseThrow();
        s.setName(sDto.getName());
        s.setSurname(sDto.getSurname());
        s.setAge(sDto.getAge());
        studentRepository.save(s);
    }
    @Override
    public void updatePath(int id, StudentDto sDto) {
        Student s = studentRepository.findById(id).orElseThrow();
        if(sDto.getName() != null)
        s.setName(sDto.getName());
        if (sDto.getSurname() != null)
        s.setSurname(sDto.getSurname());
        if (sDto.getAge() != 0)
        s.setAge(sDto.getAge());
        studentRepository.save(s);
    }

    public static StudentDto convertDto(Student s){
        return StudentDto.builder()
                .id(s.getId())
                .name(s.getName())
                .surname(s.getSurname())
                .age(s.getAge())
                .build();
    }

    public static Student convertEntity(StudentDto sDto){
        return Student.builder()
                .id(sDto.getId())
                .name(sDto.getName())
                .surname(sDto.getSurname())
                .age(sDto.getAge())
                .build();
    }

}
