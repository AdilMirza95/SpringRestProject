package az.developer.springrest1.controller;

import az.developer.springrest1.rest.model.request.StudentDto;
import az.developer.springrest1.rest.model.response.StudentResponse;
import az.developer.springrest1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public StudentResponse getAllStudents(){

        return studentService.getAllStudents();
   }

   @GetMapping("/{id}")
   public StudentDto getStudentById(@PathVariable("id") int id){

        return studentService.getStudentById(id);
   }

   @GetMapping("/search")
   public StudentResponse getStudentByName(@RequestParam("name") String name){
        return studentService.getStudentByName(name);
   }

   @PostMapping
   public void insert(@RequestBody StudentDto sDto){

        studentService.insert(sDto);
   }

   @PutMapping("{id}")
   public void updatePut(@PathVariable("id") int id,@RequestBody StudentDto sDto){

        studentService.updatePut(id,sDto);
   }

   @PatchMapping("{id}")
   public void updatePatch(@PathVariable("id") int id,@RequestBody StudentDto sDto){
        studentService.updatePath(id,sDto);
   }




}