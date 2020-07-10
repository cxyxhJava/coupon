//package com.frank.controller;
//
//import com.frank.entity.User;
//import com.frank.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @ Author     ：杨晓波
// * @ Date       ：Created in 14:43 2020-05-28
// * @ Description：登陆
// * @ Modified By：
// */
//@RestController
//public class LoginController {
//    @Autowired private UserService userService;
//
//
//    @PostMapping("/user/save")
//    public Integer save(@Validated @RequestBody User user) {
//        return userService.save(user);
//    }
//
//
//    @DeleteMapping("/user/delete/{id}")
//    public void delete(@PathVariable(name = "id") Integer id) {
//        userService.delete(id);
//        return;
//    }
//
//    @GetMapping("/user/detail/{id}")
//    public User detail(@PathVariable(name = "id") Integer id) {
//        return userService.detail(id);
//    }
//
//
//
//}
