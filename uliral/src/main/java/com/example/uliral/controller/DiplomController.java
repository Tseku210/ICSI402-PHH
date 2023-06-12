package com.example.uliral.controller;

import com.example.uliral.model.DTO.DiplomDto;
import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Internship;
import com.example.uliral.model.entities.Student;
import com.example.uliral.model.enums.StudentEntityType;
import com.example.uliral.model.factory.StudentEntityFactory;
import com.example.uliral.services.DiplomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diplom")
public class DiplomController {
    private final DiplomService diplomService;

    @Autowired
    public DiplomController(DiplomService diplomService) {
        this.diplomService = diplomService;
    }

    @GetMapping
    public String getAllDiploms(Model model, @RequestParam(value = "search", required = false) String search) {
        if (search == null) {
            search = "";
        }

        List<Diplom> diploms = diplomService.findAll(search);
        model.addAttribute("diploms", diploms);
        return "diplom";
    }

    @PostMapping("add")
    public String addDiplom(@ModelAttribute DiplomDto diplomDto) {
        Diplom diplom = (Diplom) StudentEntityFactory.createEntity(StudentEntityType.DIPLOMA);
        Student student = (Student) StudentEntityFactory.createEntity(StudentEntityType.STUDENT);
        student.setStudent_id(diplomDto.getStudentId());
        diplom.setStudent(student);
        diplom.setUniversityName(diplomDto.getUniversity());
        diplom.setDegreeName(diplomDto.getDegreeName());
        diplom.setGraduationYear(diplomDto.getGraduationYear());

        diplomService.insert(diplom);
        return "redirect:/diplom";
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("diplomId") int diplomId) {
        boolean success = diplomService.deleteById(diplomId);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
