package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Custommer;
import com.example.demo.repository.CustommerRepository;

@Controller

public class CustommerController {
    @Autowired
    private CustommerRepository custommerRepository;

    @GetMapping("/Custommer/{custommerID}")
    public ResponseEntity<Custommer> getCustommer(@PathVariable Integer custommerID) {
        return custommerRepository.findById(custommerID).map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/newCustommer")
    public String newCustommer(@ModelAttribute Custommer newCustommer) {
        custommerRepository.save(newCustommer);
        return "redirect:/";
    }

    @PostMapping("/uptCustommer/{custommerID}")
    public String updateCustommer(@ModelAttribute Custommer newCustommer, @PathVariable String custommerID) {
        try {
            Integer parsedCustommerID = Integer.parseInt(custommerID);
            custommerRepository.findById(parsedCustommerID).ifPresent(cust -> {
                cust.setName(newCustommer.getName());
                cust.setSurname(newCustommer.getSurname());
                cust.setNumber(newCustommer.getNumber());
                cust.setAdress(newCustommer.getAdress());
                custommerRepository.save(cust);
            });
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update customer");
        }
    }

    @GetMapping("/delCustommer/{custommerID}")
    String deleteCustommer(@PathVariable Integer custommerID) {

        custommerRepository.deleteById(custommerID);
        return "redirect:/";
    }
}
