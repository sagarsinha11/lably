package com.xfactor.lably.controllers;


import antlr.collections.List;
import com.xfactor.lably.entity.Lab;
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
 * LabController
 */
@RestController
@RequestMapping("/lab")
public class LabController {

    ArrayList<Lab> labs = new ArrayList<>();

    @GetMapping()
    public String lab(){
        return "You opened Lab Controller.";
    }

    @PostMapping("/addingLab")
    public Lab addingLab(@RequestBody Lab lab) {
        lab.setId(UUID.randomUUID().toString());
        // Save admin to db
        labs.add(lab);
        return lab;
    }

    @GetMapping("/getAllLabs")
    public ArrayList<Lab> getAllLabs() {
        ArrayList<Lab> arr=new ArrayList();

        return arr;
    }

    @GetMapping("/getLabByName")
    public Lab getLabByName(@RequestParam String name) {
        Lab resLab = null;
        for (Lab lab : labs) {
            if (lab.getName().equalsIgnoreCase(name)) {
                resLab = lab;
            }
        }
        return resLab;
    }

}
