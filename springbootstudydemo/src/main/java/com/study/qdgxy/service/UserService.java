package com.study.qdgxy.service;

import com.study.qdgxy.mapper.UserMapper;
import com.study.qdgxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        User userByName = userMapper.findUserByName(username);
        if(userByName==null){
            return false;
        }else {
           if(userByName.getPassword().equals(password)){
               return true;
           } else {
               return false;
           }
        }
    }
}
