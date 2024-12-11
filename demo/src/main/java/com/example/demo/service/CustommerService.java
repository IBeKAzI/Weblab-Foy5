package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Custommer;
import com.example.demo.repository.CustommerRepository;

@Service
public class CustommerService {
@Autowired
private CustommerRepository custommerRepository;
public List<Custommer> getAllCustommers(){
    return custommerRepository.findAll();
}
}
