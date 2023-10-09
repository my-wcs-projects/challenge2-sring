package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;

import static java.lang.Character.getName;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public ResponseEntity<?> doctor(@PathVariable int number) {
        if(number >= 1 && number <= 12) {
            return ResponseEntity.status(HttpStatus.SEE_OTHER).location(URI.create("/")).body(null);
        } else if(number == 13) {
            Doctor doctor = new Doctor(13, "Jodie Whittaker");
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossible de récupérer l'incarnation " + number + ".");
        }
    }

}
