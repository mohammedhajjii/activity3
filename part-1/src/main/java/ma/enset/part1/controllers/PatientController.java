package ma.enset.part1.controllers;

import lombok.AllArgsConstructor;
import ma.enset.part1.entities.Patient;
import ma.enset.part1.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;




    @GetMapping("/all")
    public String getPatients(Model model){
        model.addAttribute("patients", patientRepository.findAll());
        return "patient";
    }

}
