package com.nest.complaintapp_backend.controller;

import com.nest.complaintapp_backend.dao.ComplaintDao;
import com.nest.complaintapp_backend.model.ComplaintModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addcomplaint",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addComplaint(@RequestBody ComplaintModel complaint){
        dao.save(complaint);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Map<String,String>> viewAllComplaints(){
        return (List<Map<String,String>>) dao.viewAllComplaints();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/viewmycomplaints")
    public List<ComplaintModel> viewMyComplaints(@RequestBody ComplaintModel c){
        return (List<ComplaintModel>) dao.viewMyComplaints(c.getId());
    }
}
