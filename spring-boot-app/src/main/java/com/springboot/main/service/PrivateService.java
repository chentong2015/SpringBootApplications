package com.springboot.main.service;

import org.springframework.stereotype.Service;

@Service
public class PrivateService {

    public void print() {
        System.out.println("Private service");
    }
}