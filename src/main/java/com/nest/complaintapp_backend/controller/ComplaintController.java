package com.nest.complaintapp_backend.controller;

import com.nest.complaintapp_backend.model.UserModel;
import com.nest.complaintapp_backend.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

@RestController
public class ComplaintController {

    @Autowired
    private UserDao userdao;

    @GetMapping("/")
    public String home(){
        return "Welcome to the complaint api";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/useradd",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> userReg(@RequestBody UserModel user){
        userdao.save(user);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userverify",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> userVerify(@RequestBody UserModel user){
        HashMap<String, String> map = new HashMap<>();
        int id = user.getId();
        List<UserModel> result = (List<UserModel>) userdao.userVerify(user.getUsername(),user.getPassword());
        if(result.size()>0){
            map.put("status","success");
            map.put("userId",String.valueOf(user.getId()));
        }
        return map;
    }
}
