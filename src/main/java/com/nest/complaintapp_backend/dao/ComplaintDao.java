package com.nest.complaintapp_backend.dao;

import com.nest.complaintapp_backend.model.ComplaintModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<ComplaintModel,Integer> {

    @Query(value = "SELECT u.name,u.address,u.email,u.phone_no,c.complaint FROM `users` as u JOIN `complaints` AS c ON u.id = c.user_id",nativeQuery = true)
    List<Map<String,String>> viewAllComplaints();

    @Query(value = "SELECT * FROM `complaints` WHERE `user_id` = :userId",nativeQuery = true)
    List<ComplaintModel> viewMyComplaints(Integer userId);
}
