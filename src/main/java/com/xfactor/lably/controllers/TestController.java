package com.xfactor.lably.controllers;


import antlr.collections.List;
import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.entity.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestsController
 */
@RestController
@RequestMapping("/test")
public class TestController {

    ArrayList<Test> tests = new ArrayList<>();

    @GetMapping()
    public String test(){
        return "You opened Tests Controller.";
    }

    @PostMapping("/addingTests")
    public Test addingTest(@RequestBody Test test) {
        test.setId(UUID.randomUUID().toString());
        // Save admin to db
        tests.add(test);
        return test;
    }

    @GetMapping("/getAllTest")
    public ArrayList<Test> getAlTests() {
        //ArrayList<Test> aList=new ArrayList();
        
        return tests;
    }

    @GetMapping("/getTestByName")
    public Test getTestByName(@RequestParam String name) {
        Test resTest = null;
        for (Test test : tests) {
            if (test.getName().equalsIgnoreCase(name)) {
                resTest = test;
            }
        }
        return resTest;
    }
}