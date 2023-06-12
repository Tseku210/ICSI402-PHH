package com.example.uliral.controller;

import com.example.uliral.model.DTO.InternshipDto;
import com.example.uliral.model.DTO.StudentDTO;
import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Internship;
import com.example.uliral.model.entities.Student;
import com.example.uliral.model.enums.StudentEntityType;
import com.example.uliral.model.factory.StudentEntityFactory;
import com.example.uliral.services.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/internship")
public class InternshipController {
    private final InternshipService internshipService;

    @Autowired
    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @GetMapping
    public String getAllInternships(Model model, @RequestParam(value = "search", required = false) String search) {
        if (search == null) {
            search = "";
        }

        List<Internship> internships = internshipService.findAll(search);
        model.addAttribute("internships", internships);
        return "internship";
    }

    @PostMapping("add")
    public String registerNewInternship(@ModelAttribute InternshipDto internshipDto) {
        Internship internship = (Internship) StudentEntityFactory.createEntity(StudentEntityType.INTERNSHIP);
        Student student = (Student) StudentEntityFactory.createEntity(StudentEntityType.STUDENT);
        student.setStudent_id(internshipDto.getStudentId());
        internship.setStudent(student);
        internship.setCompanyName(internshipDto.getCompanyName());
        internship.setDuration(internshipDto.getDuration());

        internshipService.insert(internship);
        return "redirect:/internship";
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("internshipId") int internshipId) {
        boolean success = internshipService.deleteById(internshipId);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
