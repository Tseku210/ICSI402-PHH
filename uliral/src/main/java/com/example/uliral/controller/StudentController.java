package com.example.uliral.controller;

import com.example.uliral.model.DTO.StudentDTO;
import com.example.uliral.model.entities.Student;
import com.example.uliral.model.entities.StudentEntity;
import com.example.uliral.model.enums.StudentEntityType;
import com.example.uliral.model.factory.StudentEntityFactory;
import com.example.uliral.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model, @RequestParam(value = "search", required = false) String search) {
        if (search == null) {
            search = "";
        }
        List<Student> students = studentService.findAll(search);
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("add")
    public String registerNewStudent(@ModelAttribute StudentDTO studentDto) {
        Student student = (Student) StudentEntityFactory.createEntity(StudentEntityType.STUDENT);
        student.setStudent_id(studentDto.getStudentId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNo(studentDto.getPhoneNo());

        studentService.insert(student);
        return "redirect:/";
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("studentId") String studentId) {
        boolean success = studentService.deleteById(studentId);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
