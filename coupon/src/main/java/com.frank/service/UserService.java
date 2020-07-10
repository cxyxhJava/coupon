//package com.frank.service;
//
//import com.frank.dao.UserRepository;
//import com.frank.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @ Author     ：杨晓波
// * @ Date       ：Created in 15:14 2020-05-28
// * @ Description：
// * @ Modified By：
// */
//@Service
//public class UserService {
//    @Autowired private UserRepository userRepository;
//
//    public Integer save(User user){
//        User result = userRepository.save(user);
//        return result.getId();
//    }
//
//    public void delete(Integer id){
//        userRepository.deleteById(id);
//    }
//
//    public User detail(Integer id){
//       return userRepository.findById(id).get();
//    }
//
//
//
//}
