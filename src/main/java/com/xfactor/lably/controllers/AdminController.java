package com.xfactor.lably.controllers;


import antlr.collections.List;
import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.entity.Admin;

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
 * AdminController
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins=new ArrayList();

    @GetMapping()
    public String admin() {
        return "You opened Admin Controller.";
    }

    @PostMapping("/addingAdmin")
    public Admin addingAdmin(@RequestBody Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        // Save admin to db
        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAllAdmin")
    public ArrayList<Admin> getAllAdmin() {
        // ArrayList<Admin> arrList=new ArrayList();
        
        return admins;
    }

    @GetMapping("/getAdminByName")
    public Admin getAdminByName(@RequestParam String name) {
        Admin resAdmin = null;
        for (Admin admin : admins) {
            if (admin.getName().equalsIgnoreCase(name)) {
                resAdmin = admin;
            }
        }
        return resAdmin;
    }
}