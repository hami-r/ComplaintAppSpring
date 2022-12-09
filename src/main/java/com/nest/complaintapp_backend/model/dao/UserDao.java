package com.nest.complaintapp_backend.model.dao;

import com.nest.complaintapp_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`,`address`,`email`,`name`,`password`,`phone_no`,`username` FROM `users` WHERE `username` =:username AND `password` = :password",nativeQuery = true)
    List<UserModel> userVerify(String username,String password);
}
